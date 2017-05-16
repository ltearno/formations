package fr.lteconsulting.client;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.user.client.ui.RootLayoutPanel;

public class Application implements EntryPoint
{
	private Canvas canvas;
	private Context2d ctx;

	private ImageElement image = Document.get().createImageElement();
	private ImageElement bulletImage = Document.get().createImageElement();

	private static final int WIDTH = 600;
	private static final int HEIGHT = 600;

	private static final double BASE_SPEED = .2; // units per millisecond
	private static final double BASE_ANGLE_SPEED = .002; // radians per millisecond

	private static final double BULLET_SPEED = .8; // units per millisecond

	double speed = 0;
	double speedAngle = 0;
	Double lastUpdated = null;

	private double x = WIDTH / 2;
	private double y = HEIGHT / 2;
	private double angle = 0;

	private List<Bullet> bullets = new ArrayList<>();

	static class Bullet
	{
		private double x;
		private double y;
		private double angle;
	}

	@Override
	public void onModuleLoad()
	{
		image.setSrc( "http://2.bp.blogspot.com/-pHN1M-dCJJk/UM9kJo6AXkI/AAAAAAAAAQA/4RZoJ4bccv4/s85/medfighter.png" );
		bulletImage.setSrc( "http://4.bp.blogspot.com/-HKe2vwr7g60/UM9kDbK_v8I/AAAAAAAAAPo/L_W6t4riGFA/s64/smallfreighterspr.png" );

		initGui();

		initGuiHandlers();

		canvas.setFocus( true );

		frame();
	}

	private void frame()
	{
		Utils.requestAnimationFrame( () -> {
			updatePosition();

			drawCanvas();

			frame();
		} );
	}

	private void updatePosition()
	{
		double now = Utils.now();

		if( lastUpdated == null )
		{
			lastUpdated = now;
			return;
		}

		double difference = now - lastUpdated;
		lastUpdated = now;

		ListIterator<Bullet> it = bullets.listIterator();
		while( it.hasNext() )
		{
			Bullet b = it.next();

			b.x += -Math.cos( b.angle + Math.PI / 2 ) * (BULLET_SPEED * difference);
			b.y += -Math.sin( b.angle + Math.PI / 2 ) * (BULLET_SPEED * difference);

			if( b.x > WIDTH + 64 || b.x < -64 || b.y > HEIGHT + 64 || b.y < -64 )
				it.remove();
		}

		if( speed == 0 && speedAngle == 0 )
			return;

		if( speedAngle != 0 )
			angle += speedAngle * difference;

		x += -Math.cos( angle + Math.PI / 2 ) * (speed * difference);
		y += -Math.sin( angle + Math.PI / 2 ) * (speed * difference);
	}

	private void drawCanvas()
	{
		ctx.clearRect( 0, 0, WIDTH, HEIGHT );

		ctx.setLineWidth( 50 );
		ctx.setStrokeStyle( "blue" );
		ctx.setFillStyle( "red" );

		ctx.translate( x, y );
		ctx.rotate( angle );
		ctx.drawImage( image, -42, -42 );
		ctx.rotate( -angle );
		ctx.translate( -x, -y );

		for( Bullet b : bullets )
		{
			ctx.translate( b.x, b.y );
			ctx.drawImage( bulletImage, -32, -32 );
			ctx.translate( -b.x, -b.y );
		}

		ctx.fillText( "Speed:" + speed + " angleSpeed:" + speedAngle + " x:" + x + " y:" + y + " angle:" + angle, 10, 10 );
	}

	/**
	 * Construit l'interface graphique de l'application
	 */
	private void initGui()
	{
		canvas = Canvas.createIfSupported();
		canvas.setSize( "100%", "100%" );

		canvas.setCoordinateSpaceWidth( WIDTH );
		canvas.setCoordinateSpaceHeight( HEIGHT );

		ctx = canvas.getContext2d();

		RootLayoutPanel.get().add( canvas );
	}

	/**
	 * Branche les différents évènements de l'interface graphique sur
	 * les actions appropriées
	 */
	private void initGuiHandlers()
	{
		canvas.addKeyDownHandler( event -> {
			if( event.getNativeKeyCode() == KeyCodes.KEY_UP )
			{
				speed = BASE_SPEED;
			}
			else if( event.getNativeKeyCode() == KeyCodes.KEY_DOWN )
			{
				speed = -BASE_SPEED;
			}
			else if( event.getNativeKeyCode() == KeyCodes.KEY_LEFT )
			{
				speedAngle = -BASE_ANGLE_SPEED;
			}
			else if( event.getNativeKeyCode() == KeyCodes.KEY_RIGHT )
			{
				speedAngle = BASE_ANGLE_SPEED;
			}
			else if( event.getNativeKeyCode() == KeyCodes.KEY_SPACE )
			{
				Bullet b = new Bullet();
				b.x = x;
				b.y = y;
				b.angle = angle;
				bullets.add( b );
			}
		} );

		canvas.addKeyUpHandler( event -> {
			if( event.getNativeKeyCode() == KeyCodes.KEY_UP )
			{
				speed = 0;
			}
			else if( event.getNativeKeyCode() == KeyCodes.KEY_DOWN )
			{
				speed = 0;
			}
			else if( event.getNativeKeyCode() == KeyCodes.KEY_LEFT )
			{
				speedAngle = 0;
			}
			else if( event.getNativeKeyCode() == KeyCodes.KEY_RIGHT )
			{
				speedAngle = 0;
			}
		} );
	}
}