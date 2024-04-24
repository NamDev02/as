package com.example.GraduationThesis.View.Login.MenuFrame.TabsController.TabUsersData;

import com.example.GraduationThesis.View.Login.MenuFrame.TabsController.DecoratorButton.ActionType;
import com.example.GraduationThesis.View.Login.MenuFrame.TabsController.DecoratorButton.ButtonEditor;
import com.example.GraduationThesis.View.Login.MenuFrame.TabsController.DecoratorButton.ButtonRenderer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import javax.swing.table.TableColumn;
import java.util.List;
import java.util.Map;

public class InitializeTabUserData extends JPanel {

    private JTable table;
    private JFrame frame;

    public InitializeTabUserData(JFrame frame) {

        this.frame = frame;

        setLayout(new BorderLayout());

        // all name column in table
        String[] columns = {"ID", "Username", "Numberphone", "Email", "Roles", "Admin Authorization", "Delete",
                "ID student", "Student Name", "Email", "Birth of Date", "Address", "Number Phone", "Parents Name", "Parents Number Phone"};

        // disable editing of edit and gpa columns
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return !(column == 0 || column == 1 || column == 2 || column == 3 || column == 4
                        || column == 7 || column == 8 || column == 9 || column == 10 || column == 11 || column == 12
                        || column == 13 || column == 14);
            }
        };

        table = new JTable(model);

        // set size
        table.getColumnModel().getColumn(0).setPreferredWidth(25); // ID
        table.getColumnModel().getColumn(1).setPreferredWidth(150); // Username
        table.getColumnModel().getColumn(2).setPreferredWidth(190); // Numberphone
        table.getColumnModel().getColumn(3).setPreferredWidth(250); // Email
        table.getColumnModel().getColumn(4).setPreferredWidth(120); // Roles
        table.getColumnModel().getColumn(5).setPreferredWidth(250); // Admin Authorization
        table.getColumnModel().getColumn(6).setPreferredWidth(100); // Delete User
        table.getColumnModel().getColumn(7).setPreferredWidth(180); // ID student
        table.getColumnModel().getColumn(8).setPreferredWidth(150); // Student Name
        table.getColumnModel().getColumn(9).setPreferredWidth(120); // Email
        table.getColumnModel().getColumn(10).setPreferredWidth(220); // Birth of Date
        table.getColumnModel().getColumn(11).setPreferredWidth(160); // Address
        table.getColumnModel().getColumn(12).setPreferredWidth(200); // Number Phone
        table.getColumnModel().getColumn(13).setPreferredWidth(100); // Parents Name
        table.getColumnModel().getColumn(14).setPreferredWidth(300); // Parents Number Phone


        /**
         * Enum type
         * this tab is for users so we need delete user
         * set DELETE_USER like a flag
         */
        ActionType actionType = ActionType.DELETE_USER;

        TableColumn adminAuthorizationButtonColumn = table.getColumnModel().getColumn(5);
        adminAuthorizationButtonColumn.setCellRenderer(new ButtonRenderer());
        adminAuthorizationButtonColumn.setCellEditor(new ButtonEditor(frame, new JCheckBox(), this, actionType));


        TableColumn deleteButtonColumn = table.getColumnModel().getColumn(6);
        deleteButtonColumn.setCellRenderer(new ButtonRenderer());
        deleteButtonColumn.setCellEditor(new ButtonEditor(frame, new JCheckBox(), this, actionType));

        // create title
        JLabel userInformationLabel = new JLabel("Information User");
        JLabel theirChildLabel = new JLabel("Their Child");
        userInformationLabel.setHorizontalAlignment(SwingConstants.CENTER);
        theirChildLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // add title in panel
        JPanel headerPanel = new JPanel(new GridLayout(1, 2));
        JPanel userPanel = new JPanel(new BorderLayout());
        userPanel.add(userInformationLabel, BorderLayout.CENTER);
        JPanel childPanel = new JPanel(new BorderLayout());
        childPanel.add(theirChildLabel, BorderLayout.CENTER);
        headerPanel.add(userPanel);
        headerPanel.add(childPanel);

        // add table in JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // add headerPanel and scrolPane in panel
        add(headerPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        updateData();
    }


    public void updateData() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Xóa dữ liệu hiện tại trong bảng
        List<Map<String, Object>> data = TabUsersDataAction.Action();

        // browse the list of data and add it to the table
        data.forEach(row -> {

            // filter and count the number of roles "ROLE_ADMIN"
            long adminCount = ((List<Map<String, Object>>) row.get("Roles")).stream()
                    .filter(role -> "ROLE_ADMIN".equals(role.get("Role Name")))
                    .count();

            // define roles based on quantity "ROLE_ADMIN"
            String role = (adminCount > 0) ? "Admin" : "User";


            List<Map<String, Object>> theirChildList = (List<Map<String, Object>>) row.get("Their Child");
            if (theirChildList.isEmpty()) {

                model.addRow(new Object[]{row.get("ID"), row.get("Username"), row.get("Numberphone"), row.get("Email"), role,
                        "Admin", "Delete", "", "", "", "", "", "", "", ""});
            }

            theirChildList.forEach(child -> {
                Object childID = child.get("ID");
                Object studentName = child.get("Student Name");
                Object email = child.get("Email");
                Object birthOfDate = child.get("Birth of Date");
                Object address = child.get("Address");
                Object numberPhone = child.get("Number Phone");
                Object parentsName = child.get("Parents Name");
                Object parentsNumberPhone = child.get("Parents Number Phone");
                model.addRow(new Object[]{row.get("ID"), row.get("Username"), row.get("Numberphone"), row.get("Email"), role,
                        "Admin", "Delete", childID, studentName, email, birthOfDate, address, numberPhone, parentsName, parentsNumberPhone});
            });
        });
    }


    public void deleteRecord(int rowIndex) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.removeRow(rowIndex);
    }
}
