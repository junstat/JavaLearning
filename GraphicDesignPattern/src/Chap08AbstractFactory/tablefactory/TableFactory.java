package Chap08AbstractFactory.tablefactory;

import Chap08AbstractFactory.factory.Factory;
import Chap08AbstractFactory.factory.Link;
import Chap08AbstractFactory.factory.Page;
import Chap08AbstractFactory.factory.Tray;

public class TableFactory extends Factory {

    @Override
    public Link createLink(String caption, String url) {
        return new TableLink(caption, url);
    }

    @Override
    public Tray createTray(String caption) {
        return new TableTray(caption);
    }

    @Override
    public Page createPage(String title, String author) {
        return new TablePage(title, author);
    }

}

