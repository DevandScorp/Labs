package Lab_11.v_5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.lang.reflect.Field;
import java.util.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class View extends JFrame {

    /**
     * UTILITIES
     */
    private List<User> userList = new ArrayList<User>();
    private boolean isAscending = false;
    private DateFormat dateFormat = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
    private Map<Object, Long> currentValues;
    private final String[] FIELDS = {
            "name",
            "surname",
            "patronymic",
            "phone",
            "area",
            "address",
            "dealNumber",
            "dealDate",
            "userPay",
            "lastPay"
    };

    /**
     * COMPONENTS
     */
    private JMenuBar menuBar = new JMenuBar();
    private JMenu fileMenu = new JMenu("File");
    private JMenuItem load = new JMenuItem("Load");
    private JMenuItem save = new JMenuItem("Save");
    private JList listView;
    private JPanel listPanel;
    private JPanel formPanel;
    private JTextField nameInput = new JTextField();
    private JTextField surnameInput = new JTextField();
    private JTextField patronymicInput = new JTextField();
    private JTextField phoneNumberInput = new JTextField();
    private JTextField areaInput = new JTextField();
    private JTextField addressInput = new JTextField();
    private JTextField dealNumberInput = new JTextField();
    private JTextField dealDateInput = new JTextField();
    private JTextField userPayInput = new JTextField();
    private JTextField lastPayInput = new JTextField();
    private JFileChooser fileChooser = new JFileChooser("C:\\Users\\User\\IdeaProjects\\Labs\\src\\Lab_11\\v_5");
    private JButton submit = new JButton("Submit");
    private JButton remove = new JButton("Remove");
    private JTextField currentValue = new JTextField(15);
    private JButton showAscendingSort = new JButton("Ascending sort");
    private JButton showDescendingSort = new JButton("Descending sort");
    private JButton getPreviousElement = new JButton("The previous one");
    private JButton getNextElement = new JButton("The next one");
    private JButton getCurrentElement = new JButton("Current index");
    private JPanel panel = new JPanel();
    private JPanel statusPanel = new JPanel();
    private JLabel status = new JLabel("Here is my status");
    private JPanel southPanel = new JPanel(new BorderLayout());
    private DefaultListModel<User> listModel = new DefaultListModel();
    private JComboBox comboBox = new JComboBox(FIELDS);


    public View() throws HeadlessException {
        /**Initialize and add elements*/

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0, 0, screenSize.width, screenSize.height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        listPanel = new JPanel();
        remove.setSize(200, 100);
        showAscendingSort.setSize(200, 100);
        showDescendingSort.setSize(200, 100);
        getCurrentElement.setSize(200, 100);
        getPreviousElement.setSize(200, 100);
        getNextElement.setSize(200, 100);
        listView = new JList(listModel);
        listView.setFixedCellWidth(1300);
        listPanel.add(listView);
        nameInput.setToolTipText("Name");
        surnameInput.setToolTipText("Surname");
        patronymicInput.setToolTipText("Patronymic");
        phoneNumberInput.setToolTipText("Phone number");
        areaInput.setToolTipText("Area");
        addressInput.setToolTipText("Address");
        dealNumberInput.setToolTipText("Deal Number");
        dealDateInput.setToolTipText("Deal Date");
        userPayInput.setToolTipText("User Pay");
        lastPayInput.setToolTipText("Last Pay");
        panel.setLayout(new BorderLayout());
        panel.add(listPanel, BorderLayout.NORTH);
        setContentPane(panel);
        fileMenu.add(load);
        fileMenu.add(save);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
        formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.add(currentValue);
        formPanel.add(remove);
        formPanel.add(getCurrentElement);
        formPanel.add(getPreviousElement);
        formPanel.add(getNextElement);
        formPanel.add(showAscendingSort);
        formPanel.add(showDescendingSort);
        formPanel.add(comboBox);
        formPanel.add(nameInput);
        formPanel.add(surnameInput);
        formPanel.add(patronymicInput);
        formPanel.add(phoneNumberInput);
        formPanel.add(areaInput);
        formPanel.add(addressInput);
        formPanel.add(dealNumberInput);
        formPanel.add(dealDateInput);
        formPanel.add(userPayInput);
        formPanel.add(lastPayInput);
        formPanel.add(submit);
        statusPanel.add(status);
        southPanel.add(formPanel, BorderLayout.CENTER);
        southPanel.add(statusPanel, BorderLayout.SOUTH);
        panel.add(southPanel, BorderLayout.SOUTH);
        setLocationRelativeTo(null);
        setVisible(true);
        /**ACTION LISTENERS*/
        submit.addActionListener(e -> {
            try {
                String name = nameInput.getText();
                String surname = surnameInput.getText();
                String patronymic = patronymicInput.getText();
                String phoneNumber = phoneNumberInput.getText();
                String area = areaInput.getText();
                String address = addressInput.getText();
                Long dealNumber = Long.parseLong(dealNumberInput.getText());
                Date dealDate = dateFormat.parse(dealDateInput.getText());
                Long userPay = Long.parseLong(userPayInput.getText());
                Date lastPay = dateFormat.parse(lastPayInput.getText());
                User user = new User(name, surname, patronymic, phoneNumber, area, address, dealNumber, dealDate, userPay, lastPay);
                userList.add(user);
                listModel.addElement(user);
            } catch (ParseException e1) {
                status.setText("Error: problems with date parsing");
            }
        });
        showAscendingSort.addActionListener(e -> {
            if (!isAscending) {
                listModel.removeAllElements();
                for (int i = userList.size() - 1; i >= 0; --i) {
                    if (!userList.get(i).isDeleted()) {
                        listModel.addElement(userList.get(i));
                    }
                }
                isAscending = true;
            }

        });
        showDescendingSort.addActionListener(e -> {
            if (isAscending) {
                listModel.removeAllElements();
                for (int i = 0; i < userList.size(); ++i) {
                    if (!userList.get(i).isDeleted()) {
                        listModel.addElement(userList.get(i));
                    }

                }
                isAscending = false;
            }

        });
        getCurrentElement.addActionListener(e -> {
            String value = currentValue.getText();
            if (value.length() == 0) return;
            try {
                Field field = User.class.getDeclaredField(comboBox.getSelectedItem().toString());
                field.setAccessible(true);
                userList.forEach(a -> {
                    try {
                        if (field.get(a).toString().equals(value) && !a.isDeleted()) {
                            JOptionPane.showMessageDialog(this, " Here is your class " + a);

                        }
                    } catch (IllegalAccessException e1) {
                        e1.printStackTrace();
                    }

                });
            } catch (NoSuchFieldException e1) {
                e1.printStackTrace();
            }
        });
        getPreviousElement.addActionListener(e -> {
            String value = currentValue.getText();
            if (value.length() == 0) return;
            try {
                Field field = User.class.getDeclaredField(comboBox.getSelectedItem().toString());
                field.setAccessible(true);
                userList.forEach(a -> {
                    try {
                        if (field.get(a).toString().equals(value) && !a.isDeleted()) {
                            if (listModel.indexOf(a) != 0) {
                                JOptionPane.showMessageDialog(this,
                                        " Here is your class " + listModel.get(listModel.indexOf(a) - 1));
                            }
                        }
                    } catch (IllegalAccessException e1) {
                        e1.printStackTrace();
                    }

                });
            } catch (NoSuchFieldException e1) {
                e1.printStackTrace();
            }
        });
        getNextElement.addActionListener(e -> {
            String value = currentValue.getText();
            if (value.length() == 0) return;
            try {
                Field field = User.class.getDeclaredField(comboBox.getSelectedItem().toString());
                field.setAccessible(true);
                userList.forEach(a -> {
                    try {
                        if (field.get(a).toString().equals(value) && !a.isDeleted()) {
                            if (listModel.indexOf(a) != listModel.size() - 1) {
                                JOptionPane.showMessageDialog(this,
                                        " Here is your class " + listModel.get(listModel.indexOf(a) + 1));
                            }
                        }
                    } catch (IllegalAccessException e1) {
                        e1.printStackTrace();
                    }

                });
            } catch (NoSuchFieldException e1) {
                e1.printStackTrace();
            }
        });
        remove.addActionListener(e -> {
            String value = currentValue.getText();
            if (value.length() == 0) return;
            try {
                Field field = User.class.getDeclaredField(comboBox.getSelectedItem().toString());
                field.setAccessible(true);
                userList.forEach(a -> {

                    try {
                        if (field.get(a).toString().equals(value)) {
                            a.setDeleted(true);
                            listModel.removeElement(a);

                        }
                    } catch (IllegalAccessException e1) {
                        e1.printStackTrace();
                    }

                });
            } catch (NoSuchFieldException e1) {
                e1.printStackTrace();
            }
        });
        load.addActionListener(e -> {
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int result = fileChooser.showOpenDialog(View.this);

            if (result != JFileChooser.APPROVE_OPTION) {
                return;
            }
            userList.removeAll(userList);
            listModel.removeAllElements();
            File file = fileChooser.getSelectedFile();
            System.out.println(file.getName());
            try (RandomAccessFile randomAccessFile = new RandomAccessFile(file.getAbsolutePath(), "r");
                 BufferedReader bufferedReader = new BufferedReader(new FileReader(file.getAbsolutePath().replace(".dat", ".txt")))) {
                String s = null;
                while ((s = bufferedReader.readLine()) != null) {
                    String[] parts = s.split(" ");
                    long i = Long.parseLong(parts[parts.length - 1]);
                    randomAccessFile.seek(i);
                    byte[] b = new byte[1024];
                    randomAccessFile.read(b);
                    User user = Test.deserialize(b);
                    if (!user.isDeleted()) {
                        listModel.addElement(user);
                    }
                    userList.add(user);

                }
                userList.forEach(System.out::println);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        });
        save.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser("C:\\Users\\User\\IdeaProjects\\Labs\\src\\Lab_11\\v_5");
            User.setField(comboBox.getSelectedItem().toString());
            int result = fileChooser.showSaveDialog(View.this);
            if (result != JFileChooser.APPROVE_OPTION) {
                return;
            }

            File file = fileChooser.getSelectedFile();
            File mapFile = new File(file.getAbsolutePath().replace(".dat", ".txt"));
            System.out.println(file.getAbsolutePath().replace(".dat", ".txt"));
            currentValues = Test.write(userList, file.getAbsolutePath());
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(mapFile))) {
                for (var a : currentValues.entrySet()) {
                    bufferedWriter.write(a.getKey() + " " + a.getValue() + "\n");
                    bufferedWriter.flush();
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }


        });
    }
}
