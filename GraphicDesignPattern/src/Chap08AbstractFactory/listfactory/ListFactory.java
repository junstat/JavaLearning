package Chap08AbstractFactory.listfactory;

import Chap08AbstractFactory.factory.Factory;
import Chap08AbstractFactory.factory.Link;
import Chap08AbstractFactory.factory.Page;
import Chap08AbstractFactory.factory.Tray;

public class ListFactory extends Factory {
    @Override
    public Link createLink(String caption, String url) {
        return new ListLink(caption, url);
    }

    @Override
    public Tray createTray(String caption) {
        return new ListTray(caption);
    }

    @Override
    public Page createPage(String title, String author) {
        return new ListPage(title, author);
    }
}