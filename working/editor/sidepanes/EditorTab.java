package editor.sidepanes;

import javafx.scene.Node;

public class EditorTab {
	private Node content;
	private String tabDescription;
	/**
	 * @return the content
	 */
	public Node getContent() {
		return content;
	}
	/**
	 * @return the tabDescription
	 */
	public String getTabDescription() {
		return tabDescription;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(Node content) {
		this.content = content;
	}
	/**
	 * @param tabDescription the tabDescription to set
	 */
	public void setTabDescription(String tabDescription) {
		this.tabDescription = tabDescription;
	}
}
