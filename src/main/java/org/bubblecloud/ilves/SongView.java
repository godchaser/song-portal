package org.bubblecloud.ilves;

import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.VerticalLayout;

public class SongView extends CustomComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SongView() {
		setHeight("100%");
		final VerticalLayout mainLayout = new VerticalLayout();
		mainLayout.setSpacing(true);
		setCompositionRoot(mainLayout);

		final SongSearchComponent songSearchComponent = new SongSearchComponent();
		//final SongWindowComponent songWindowComponent = new SongWindowComponent();

		mainLayout.addComponent(songSearchComponent);
		//mainLayout.addComponent(songWindowComponent);
	}
}
