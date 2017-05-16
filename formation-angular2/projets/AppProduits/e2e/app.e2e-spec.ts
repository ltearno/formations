import { AppProduitsPage } from './app.po';

describe('app-produits App', function() {
  let page: AppProduitsPage;

  beforeEach(() => {
    page = new AppProduitsPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
