import java.util.NoSuchElementException;
/**    Assignment 4
 * @author x_morin
*CellList<p>
*Written by: Xavier Morin 40077865<p>
*For COMP 249 section WW-Winter 2019<p>
*Due for 4/4/2019<p>
*CellList Object<p>
* <p>
*/
public class CellList {
	private CellNode head;
	private int size;
	
	
	
	public int getSize() {
		return size;
	}

	

	/**
	 * @param head
	 * @param size
	 */
	public CellList() {
		
		this.head = null;
		this.size = 0;
	}
	
	/**
	 * @param head
	 * @param size
	 */
	public CellList(CellList list) throws NullPointerException{
		if(list==null)
			throw new NullPointerException();
		if(list.head==null)
			head=null;
		else {
			CellNode position=list.head;
			CellNode newHead;
			CellNode end =null;
			newHead=new CellNode(position.cell,null);
			end=newHead;
			position=position.pointer;
			
			while(position !=null)
			{
				end.pointer= new CellNode(position.cell,null);
				end=end.pointer;
				position=position.pointer;
			}
			head=newHead;
			size=list.size;
			
		}
		
		
	}

	/**
	 * will add one element to start of the list
	 * @param phone
	 */
	public void addToStart(CellPhone phone) {
		head=new CellNode(phone,head);
		size++;
	}
	/**
	 * will add one element at this index
	 * @param phone
	 * @param index
	 */
	public void insertAtIndex(CellPhone phone, int index) throws NoSuchElementException{
		if(index<0 || index>=size) {
			throw new NoSuchElementException();
		}
		if(index==0) {
			addToStart(phone);
		}
		else {
		 CellNode position=head;
		 for(int i=0;i<index-1;i++) {
			 position=position.pointer;	 
		 }
		CellNode N=new CellNode(phone,position.pointer);
		position.setPointer(N);}
		size++;
		
	}
	/**
	 * will delete one element at this index
	 * @param index
	 */
	public void deleteFromIndex(int index) throws NoSuchElementException{
		if(index<0 || index>=size) {
			throw new NoSuchElementException();
		}
		if(index==0) {
			head=head.pointer;	
		}
		else {
			CellNode position=head;
			for(int i=0;i<index-1;i++) {
				 position=position.pointer;	 
			 }
			position.pointer=position.pointer.pointer;
			
		}
		size--;
		
	}
	/**
	 * will delete one element at index 1
	 */
	public void deleteFromStart() {
		head.pointer=head.pointer.pointer;
		size--;
	}
	/**
	 * will replace the element at this index
	 * @param phone
	 * @param index
	 */
	public void replaceAtIndex(CellPhone phone, int index) {
		deleteFromIndex(index);
		insertAtIndex(phone,index);
		
	}
	/**
	 * will return the reference to the element with serial number = number
	 * @param number
	 * @return CellNode
	 */
	public CellNode find(long number) {
		
		CellNode position=head;
		 for(int i=0;i<size;i++) {
			 if(position.cell.getSerialNum()==number) {
				 return new CellNode(position);
			 }
			 position=position.pointer;	 
		 }
		
		
		return null;
	}
	/**
	 * will return a boolean to the element with serial number = number
	 * @param number
	 * @return boolean
	 */
	public boolean contains(long number) {
		CellNode position=head;
		 for(int i=0;i<size;i++) {
			 if(position.cell.getSerialNum()==number) {
				 return true;
			 }
			 position=position.pointer;	 
		 }
		
		
		return false;
		
	}
	
	/**
	 * print the ArrayList of CellPhone
	 */
	public void showContents() {
		CellNode position=head;
		 for(int i=0;i<size;i++) {
			 if(i%3==0 && i!=0)
				 System.out.print("\n");
			 System.out.print(position.cell+" ---> ");
			 
			 position=position.pointer;	 
		 }
		 System.out.print("X");
	}
	
	/**
	 * Verify that all CellPhone in those two arrayList are equals , won't care about the serialNumber
	 * @param Object
	 * @return boolean
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CellList other = (CellList) obj;
		if (head == null) {
			if (other.head != null)
				return false;
		} else if (!head.equals(other.head))
			return false;
		if (size != other.size)
			return false;
		CellNode position=head;
		CellNode poOther=other.head;
		 for(int i=0;i<size;i++) {
			 if(!position.cell.equals(poOther.cell)) {
				 return false;
			 }
			 poOther=poOther.pointer;
			 position=position.pointer;	 
		 }
		
		
		return true;
	}



	/**
	 * Node!!!!!!!!!!!!!!!!!
	 */

	private class CellNode{
		private CellPhone cell;
		private CellNode pointer;
		/**
		 * Constructor 
		 */
		public CellNode(CellPhone cell, CellNode pointer) {
			this.cell = cell;
			this.pointer = pointer;
		}
		/**
		 * Default Constructor 
		 */
		public CellNode() {
			
			this.cell = null;
			this.pointer = null;
		}
		/**
		 * Copy Constructor 
		 */
		public CellNode(CellNode node) {
			
			this.cell = node.cell;
			this.pointer = node.pointer;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			CellNode other = (CellNode) obj;
			
			if (cell == null) {
				if (other.cell != null)
					return false;
			} else if (!cell.equals(other.cell))
				return false;
			if (pointer == null) {
				if (other.pointer != null)
					return false;
			} else if (!pointer.equals(other.pointer))
				return false;
			return true;
		}
		@Override
		protected CellNode clone() {
			CellNode CN=new CellNode(this.cell,this.pointer);
			return CN;
		}
		public CellPhone getCell() {//could have privacy link since it return the reference to that object
			CellPhone NC=new CellPhone(this.cell,this.cell.getSerialNum());
			return NC;
		}
		public void setCell(CellPhone cell) {//could directly change the value privacy link passing by CellList.head.setCell()
			this.cell = new CellPhone(cell,cell.getSerialNum());
		}
		public CellNode getPointer() {//could have privacy link since it return the reference to that object
			CellNode NCN=new CellNode(this.cell,this.pointer);
			return NCN.pointer ;
		}
		public void setPointer(CellNode pointer) {//could change directly the value link passing by CellList.head.setPointer()
			this.pointer = pointer;
		}
		private CellList getOuterType() {
			return CellList.this;
		}
		
		
		
		
		
		
		
	}

}
