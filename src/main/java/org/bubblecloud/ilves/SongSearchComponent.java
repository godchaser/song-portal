package org.bubblecloud.ilves;

import org.apache.log4j.Logger;
import org.bubblecloud.ilves.database.SongSQLContainer;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Field;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class SongSearchComponent extends CustomComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = Logger
			.getLogger(SongSearchComponent.class);

	public SongSearchComponent() {

		final Panel panel = new Panel();
		setCompositionRoot(panel);

		final VerticalLayout mainLayout = new VerticalLayout();
		panel.setContent(mainLayout);
		mainLayout.setMargin(true);
		mainLayout.setSpacing(true);

		final SongSQLContainer songs = new SongSQLContainer();
		songs.getContainer()
				.sort(new Object[] { SongSQLContainer.propertyIds.SONGTITLE
						.toString() },
						new boolean[] { true });
		final ComboBox searchSongBox = new ComboBox("search songs",
				songs.getContainer());
		searchSongBox
				.setItemCaptionPropertyId(SongSQLContainer.propertyIds.SONGTITLE
						.toString());
		mainLayout.addComponent(searchSongBox);
		searchSongBox.setWidth(100, Unit.PERCENTAGE);

		final TextArea songTextArea = new TextArea();
		mainLayout.addComponent(songTextArea);
		songTextArea.setWidth(100, Unit.PERCENTAGE);
		songTextArea.setRows(30);
		// songTextArea.setHeight("100%");

		searchSongBox.addValueChangeListener(new ValueChangeListener() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				Object songID = searchSongBox.getValue();
				LOGGER.info("Selected Item: " + songID.toString());
				String songText = songs
						.getContainer()
						.getContainerProperty(
								songID,
								SongSQLContainer.propertyIds.SONGLYRICS
										.toString()).getValue().toString();
				//songTextArea.setRows(songText.split("[\n|\r]").length);
				songTextArea.setValue(songText);
			}
		});

	}

}
