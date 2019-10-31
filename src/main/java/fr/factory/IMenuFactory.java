package fr.factory;

import fr.escape.IMenu;

public interface IMenuFactory {

	public IMenu creationMenu(String type);
}
