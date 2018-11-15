package Manager;

import javafx.scene.control.ListCell;

public class MaterialFormatCell extends ListCell<Material>{
	
	public MaterialFormatCell() {}
	
	@Override
	protected void updateItem(Material item, boolean empty) {
		super.updateItem(item, empty);
		
		if(item==null||item.getName()==null) {
			setText(null);
			System.out.println("not true");
		}
		else {
			System.out.println(item.getName());
			setText(item.getName());
		}
	}

}
