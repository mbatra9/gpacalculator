/** Homework 5 Megha Batra (mb4am) 
 * List of sources used are at the bottom of this file**/

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

/**
 * @author megha batra
 *The set up of this code is that it begins with initializing all the components 
 *and then after it moves into actually opening the window and then launching the frame. 
 *The next part of my code goes into creating all of the labels and text fields that are 
 *going to be used and placed on the window/frame. After that are the buttons and the actions
 *each button will implement when clicked. 
 */



public class gpaCalculator extends JFrame {

	/** initializing swing components similar to fields**/
	private JPanel contentPane;
	private JLabel courseName;
	private JLabel gradeEntered; 
	private JLabel creditsEntered; 
	private JLabel lblTargetGpa; 
	private JTextField txtEnterACourse;
	private JTextField txtEnter;
	private JTextField txtEnterTheGrade;
	private JTextField targetGpa;
	JTable table;
	double gradePointAverage = 0;

	/**This is to open the window **/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gpaCalculator frame = new gpaCalculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**This is for creating the main frame **/
	public gpaCalculator() {
		/**Creating the Frame/Window**/
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/**Opens a mini instruction manual to help out the user **/
		JOptionPane.showMessageDialog(contentPane, "How to Use: \n 1. Enter grades in capital letters (Ex: 'A')"
				+ " \n 2. To calculate the current GPA, you must enter both credit hours and grades"
				+ "\n 3. To reset the page click the clear button"
				+ "\n 4. Quick add button will add 5 blank classes worth 3 credits each ");
		
		/**Creating the title/header of the Window/Frame**/
		JLabel lblGpaCalculator = new JLabel("GPA Calculator");
		lblGpaCalculator.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblGpaCalculator.setBounds(230, 6, 143, 16);
		contentPane.add(lblGpaCalculator);
		
		/**Label for course name**/
		courseName = new JLabel("Enter a Course Name: ");
		courseName.setBounds(6, 229, 189, 26);
		contentPane.add(courseName);
		
		/**Place where user can enter course name**/
		txtEnterACourse = new JTextField();
		txtEnterACourse.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		txtEnterACourse.setText("");
		txtEnterACourse.setBounds(137, 229, 60, 26);
		contentPane.add(txtEnterACourse);
		txtEnterACourse.setColumns(10);
		
		/**Label for credit hours**/
		creditsEntered = new JLabel("Enter Credit Hours: ");
		creditsEntered.setBounds(6, 250, 189, 26);
		contentPane.add(creditsEntered);
		
		/**Place where user can enter credit hours**/ 
		txtEnter = new JTextField();
		txtEnter.setText("");
		txtEnter.setBounds(137, 250, 60, 26);
		contentPane.add(txtEnter);
		txtEnter.setColumns(10);
		
		/**Label for grade received**/
		gradeEntered = new JLabel("Enter the Grade: ");
		gradeEntered.setBounds(6, 270, 189, 26);
		contentPane.add(gradeEntered);
	
		/**Place where user can enter grade received **/
		txtEnterTheGrade = new JTextField();
		txtEnterTheGrade.setText("");
		txtEnterTheGrade.setBounds(137, 270, 60, 26);
		contentPane.add(txtEnterTheGrade);
		txtEnterTheGrade.setColumns(10);
		
		/**JTable that creates a running list of the course info entered by the user**/
		table = new JTable();
		String[] columns = {"Course Name", "Credits", "Grades"};
		Object [] row = new Object[3];
		DefaultTableModel model = new DefaultTableModel(); 	 
		
		model.setColumnIdentifiers(columns);
		table.setModel(model);
		table.setColumnSelectionAllowed(true);
		table.setBounds(33, 47, 206, 134);
		contentPane.add(table);
		
		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(6, 25, 800, 180);
		contentPane.setLayout(null);
		contentPane.add(pane);
		
		/**This textfield will output the GPA calculated based on credits and grades entered**/
		JTextField outputTF = new JTextField();
		outputTF.setBounds(575, 229, 200, 29);
		contentPane.add(outputTF);

		/**Place where user can enter their Target GPA**/
		targetGpa = new JTextField();
		targetGpa.setText("");
		targetGpa.setBounds(575, 265, 60, 29);
		contentPane.add(targetGpa);
		targetGpa.setColumns(10);
		
		/**Label for required GPA**/
		JLabel requiredGpa = new JLabel("Required GPA: ");
		requiredGpa.setBounds(400, 300, 200, 29);
		contentPane.add(requiredGpa);
		
		/**This textfield will output the GPA calculated based on credits and grades entered**/
		JTextField outputTF2 = new JTextField();
		outputTF2.setBounds(575, 300, 150, 29);
		contentPane.add(outputTF2);
		
		
		/**The enter button takes the info put in to the textfields and adds them to the JTable**/
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**Gets the info from the textfields and stores as a variable**/
				String courseName = txtEnterACourse.getText();
				String grade = txtEnterTheGrade.getText();
				String credits = txtEnter.getText();
			
				/**Adds the values from the textfields to the JTable rows**/
				row[0] = courseName;
				row[1] = credits;
				row[2] = grade;
				model.addRow(row); 
				
				/**resets the text field so the user can input new course info **/
				txtEnterACourse.setText("");
				txtEnter.setText("");
				txtEnterTheGrade.setText("");			
			}
		});
		btnEnter.setBounds(203, 229, 117, 29);
		contentPane.add(btnEnter);
		
		/**Pressing this button quickly adds 5 courses worth 3 credits each to the JTable. I am
		*assuming that these classes will each be 3 credits as that's the easiest way to get 15 credits**/
		JButton btnQuick = new JButton("Quick Add");
		btnQuick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**Quickly adds 5 blank three credit classes **/
				row[0] = "";
				row[1] = "3"; 
				row[2] = "";
				model.addRow(row);
				row[0] = "";
				row[1] = "3"; 
				row[2] = "";
				model.addRow(row);
				row[0] = "";
				row[1] = "3"; 
				row[2] = "";
				model.addRow(row);
				row[0] = "";
				row[1] = "3"; 
				row[2] = "";
				model.addRow(row);
				row[0] = "";
				row[1] = "3"; 
				row[2] = "";
				model.addRow(row);	
			}
		});
		
		btnQuick.setBounds(203, 290, 117, 29);
		contentPane.add(btnQuick);
		
		/**The clear button removes all the data about courses in the JTable
		 * and resets the GPA previously computed based on the info entered
		 */
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);
				txtEnterACourse.setText("");
				txtEnter.setText("");
				txtEnterTheGrade.setText("");
				outputTF.setText(" ");
				outputTF2.setText(" "); 
				targetGpa.setText(" ");
			}
		});
		btnClear.setBounds(203, 260, 117, 29);
		contentPane.add(btnClear); 
		
		/**This button will remove one row of data from the JTable when clicked **/
		JButton btnRemove = new JButton("Remove Last Row");
		btnClear.addActionListener(new ActionListener() {
			public void removeRow() {
				int selRow = table.getSelectedRow();
			    if(selRow != -1) {
			        DefaultTableModel model = (DefaultTableModel)table.getModel();
			        model.removeRow(selRow);	 
				 }
		}

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			}
	
		});
		btnRemove.setBounds(190, 325, 140, 29);
		contentPane.add(btnRemove);
		
	
        /**When clicked on, this button will calculate the gpa based on the course info entered**/
        JButton btnCurrentGpa = new JButton("Calculate Current GPA: ");
        btnCurrentGpa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outputTF.setText("" + gpaCalc());
				
			}
        });
		btnCurrentGpa.setBounds(350, 229, 200, 29);
		contentPane.add(btnCurrentGpa);

		/**Button to enter target GPA**/
		JButton targetButton = new JButton("Enter Target GPA: "); 
		 targetButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String tGpa = targetGpa.getText();
					//Accounts for if the user hasn't typed in anything
					if(tGpa.isEmpty()) {
						JOptionPane.showMessageDialog(contentPane, "Please enter a  "
								+ "GPA and try again");
					}
					//calculations for required GPA
					for (int i = 0; i < table.getRowCount(); i++) {
						double total = 0; 
						double amount = Double.parseDouble(table.getValueAt(i, 1)+"");
						total += amount;
						double tgpa = Double.parseDouble(tGpa);
						double aNumber = (((total * tgpa) - (gpaCalc()*table.getRowCount()))/amount);
						outputTF2.setText("" + aNumber);
						if (aNumber <= 2.0) {
							JOptionPane.showMessageDialog(contentPane, "You could take"
									+ " less credit hours, if you'd like! ");
						}
						if(aNumber > 4.0) {
							JOptionPane.showMessageDialog(contentPane, "Try adding more credits "
									+ "and recalculating");
						}
					
						
					}
					
				}
		 });
		targetButton.setBounds(355, 265, 200, 29);
		contentPane.add(targetButton);
	}

/**This method will calculate the current GPA**/
public double gpaCalc() {
	double count = 0; 
	double hours = 0;
	for(int i = 0; i < table.getRowCount(); i++ ) {
		String grade = (String) table.getValueAt(i, 2); 
		if (grade.equals("A+")) {
			gradePointAverage = 4.0;
		}
		if (grade.equals("A")) {
			gradePointAverage = 4.0;
		}
		if (grade.equals("A-")) {
			gradePointAverage = 3.7;
		}
		if (grade.equals("B+")) {
			gradePointAverage = 3.3;
		}
		if (grade.equals("B")) {
			gradePointAverage = 3.0;
		}
		if (grade.equals("B-")) {
			gradePointAverage = 2.7;
		}
		if (grade.equals("C+")) {
			gradePointAverage = 2.3;
		}
		if (grade.equals("C")) {
			gradePointAverage = 2.0;
		}
		if (grade.equals("C-")) {
			gradePointAverage = 1.7;
		}
		if (grade.equals("D+")) {
			gradePointAverage = 1.3;
		}
		if (grade.equals("D")) {
			gradePointAverage = 1.0;
		}
		if (grade.equals("F")) {
			gradePointAverage = 0;
		}
	
		double creditTotal = Double.parseDouble(table.getValueAt(i, 1)+"");
		double gpa = (creditTotal * gradePointAverage)/creditTotal; 		
		count += gpa;
		hours = table.getRowCount();
		

		}
	count = count/hours;
	return count; 
}

}
/** Sources used: 
 * For dialog box: https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
 * For Default Table Model: https://docs.oracle.com/javase/6/docs/api/javax/swing/table/DefaultTableModel.html
 * For iterating through JTable: https://support.smartbear.com/testcomplete/docs/app-objects/specific-tasks/grids/jtable/iterating-through-rows.html
 * For JTable Set-up: https://docs.oracle.com/javase/7/docs/api/javax/swing/JTable.html
 * More help with JTable: https://www.roseindia.net/java/example/java/swing/GetCellValues.shtml
 * For JTextFields: https://docs.oracle.com/javase/tutorial/uiswing/components/textfield.html
 * Notes from class and Piazza posts
 * **/
