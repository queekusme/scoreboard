package com.carolinarollergirls.scoreboard.xml;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

import org.jdom.*;
import org.jdom.output.*;

import com.carolinarollergirls.scoreboard.*;
import com.carolinarollergirls.scoreboard.model.*;
import com.carolinarollergirls.scoreboard.file.*;

public class LoadScoreBoard extends SegmentedXmlDocumentManager
{
	public void setXmlScoreBoard(XmlScoreBoard xsB) {
		super.setXmlScoreBoard(xsB);

		Element e = createXPathElement();
		editor.addElement(e, "LoadFile");
		editor.addElement(e, "MergeFile");
		update(e);
	}

	public void reset() {
		/* Don't reset anything, as this controls loading. */
	}

	protected void processElement(Element e) {
		try {
			loadFromFile.setFile(e.getChild("LoadFile").getText()); 
			loadFromFile.load(xmlScoreBoard);
		} catch ( Exception ex ) {
		}
		try {
			loadFromFile.setFile(e.getChild("MergeFile").getText());
			loadFromFile.merge(xmlScoreBoard);
		} catch ( Exception ex ) {
		}
	}

	protected String getManagedElementName() { return "SaveLoad"; }
	protected String getManagedSubElementName() { return "Load"; }

	protected ScoreBoardFromXmlFile loadFromFile = new ScoreBoardFromXmlFile(DIRECTORY_NAME);

	public static final String DIRECTORY_NAME = "html/save";
}