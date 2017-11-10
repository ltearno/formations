import { OrchardPage } from './app.po';

describe('orchard App', () => {
  let page: OrchardPage;

  beforeEach(() => {
    page = new OrchardPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
