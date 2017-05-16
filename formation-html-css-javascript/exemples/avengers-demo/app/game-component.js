import chainPrototypes from './chainPrototypes';
import GraphicComponent from './graphic-component';

/** GameComponent */

const WIDTH = 600;
const HEIGHT = 600;

function GameComponent() {
    GraphicComponent.call(this, `<canvas component-id="canvas" width='${WIDTH}' height='${HEIGHT}'></canvas>`);

    this.image = document.createElement('img');
    this.image.src = 'medfighter.png';

    this.ctx = this.elements.canvas.getContext('2d');

    this.shipCoordinates = { x: WIDTH / 2, y: HEIGHT / 2, angle: 0 };
    this.targetCoordinates = { x: WIDTH / 2, y: HEIGHT / 2 };

    let onFrame = () => {
        this.update();
        this.draw();

        if (!this.shouldStop)
            requestAnimationFrame(onFrame);
    }
    requestAnimationFrame(onFrame);

    this.elements.canvas.addEventListener('mousemove', (event) => {
        let rect = this.elements.canvas.getBoundingClientRect();
        let dw = rect.right - rect.left;
        let dh = rect.bottom - rect.top;

        let scaleX = WIDTH / dw;
        let scaleY = HEIGHT / dh;

        this.targetCoordinates = {
            x: (event.clientX - rect.left) * scaleX,
            y: (event.clientY - rect.top) * scaleY
        };
    });
}

chainPrototypes(GameComponent, GraphicComponent);

GameComponent.prototype.stop = function () {
    this.shouldStop = true;
}

GameComponent.prototype.update = function () {
    this.shipCoordinates.x += (this.targetCoordinates.x - this.shipCoordinates.x) / 10;
    this.shipCoordinates.y += (this.targetCoordinates.y - this.shipCoordinates.y) / 10;

    if (Math.abs(this.targetCoordinates.x - this.shipCoordinates.x) > 0) {
        this.shipCoordinates.angle = Math.atan((this.targetCoordinates.y - this.shipCoordinates.y) / (this.targetCoordinates.x - this.shipCoordinates.x));
        if (this.targetCoordinates.x < this.shipCoordinates.x)
            this.shipCoordinates.angle += Math.PI;
    }
}

GameComponent.prototype.draw = function () {
    this.ctx.clearRect(0, 0, WIDTH, HEIGHT);

    this.ctx.lineWidth = 50;
    this.ctx.strokeStyle = "blue";
    this.ctx.fillStyle = "red";

    this.ctx.beginPath();
    this.ctx.moveTo(this.shipCoordinates.x, this.shipCoordinates.y);
    this.ctx.lineTo(this.targetCoordinates.x, this.targetCoordinates.y);
    this.ctx.stroke();

    this.ctx.translate(this.shipCoordinates.x, this.shipCoordinates.y);
    this.ctx.rotate(this.shipCoordinates.angle + Math.PI / 2);
    this.ctx.drawImage(this.image, -42.5, -42.5);
    this.ctx.rotate(-this.shipCoordinates.angle - Math.PI / 2);
    this.ctx.translate(-this.shipCoordinates.x, -this.shipCoordinates.y);

    this.ctx.fillText(`Angle:${this.shipCoordinates.angle}`, 10, 10);
}

export default GameComponent;