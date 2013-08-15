package com.teamtter.sphere;

import java.awt.Component;
import java.util.List;

public interface ISphereModule {
	public String getName();

	public Component getMainPage();

	public List<Component> getPages();
}
