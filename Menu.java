import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class Menu extends JFrame {
    public Menu() {
        getContentPane().setLayout(new GridLayout(4,1));
        Consumer<Integer> difficultyConsumer = i -> {
            if (i > 0) {
                int[][] default_configs = new int[][]{{9, 9, 15, 10},
                        {16, 16, 15, 40},
                        {16, 30, 15, 99},};
                int[] selectedConfig = default_configs[i-1];
                Configuration.loadParameters(selectedConfig);
                JFrame frame = new JFrame();
                JLabel statusbar = new JLabel("select a cell");
                frame.add(statusbar, BorderLayout.SOUTH);
                frame.add(new Board(Configuration.ROWS, Configuration.COLS, Configuration.MINES, statusbar, s -> {
                    JOptionPane.showMessageDialog(this.getContentPane(), s);
                    frame.setVisible(false);
                    new Menu();
                }));
                frame.setResizable(false);
                frame.pack();
                frame.setTitle("Ekrem's Minefield");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
            else {
                System.exit(0);
            }
        };
        getContentPane().add(new DifficultyButton("Easy (9x9)", 1, difficultyConsumer));
        getContentPane().add(new DifficultyButton("Intermediate (16x16)", 2, difficultyConsumer));
        getContentPane().add(new DifficultyButton("Difficult (16x30)", 3, difficultyConsumer));
        getContentPane().add(new DifficultyButton("Quit", 0, difficultyConsumer));
        pack();
        setTitle("Ekrem's Minefield");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private class DifficultyButton extends Button {
        public DifficultyButton(String label, int value, Consumer<Integer> difficultyConsumer) throws HeadlessException {
            super(label);
            addActionListener(e -> {
                difficultyConsumer.accept(value);
                Menu.this.setVisible(false);
            });
        }
    }

    public interface CompletionListener {
         void handle(String result);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(Menu::new);
    }
}
