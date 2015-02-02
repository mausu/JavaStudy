package Chapter1;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
 
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
 
/**
 * VectorExample.java TECHSCORE Java ユーティリティ1章 実習課題1
 *
 * Copyright (c) 2004 Four-Dimensional Data, Inc.
 */
public class VectorExample extends JFrame implements ActionListener {

	private JButton continent[] = { 
			new JButton("Euracia"),
			new JButton("North America"), 
			new JButton("Africa"),
			new JButton("Australia"), 
			new JButton("South America") 
	};

	private JButton display;
	private JButton initialize;

	private Vector<JButton> vector = new Vector<JButton>();

	public VectorExample() {
		super("Vector example");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// 記憶させるテキストを示すボタンを5つ作成
		Color backColor[] = { Color.green, Color.blue, Color.black,
				Color.yellow, Color.red };

		Color foreColor[] = { Color.black, Color.white, Color.white,
				Color.black, Color.white };

		Dimension size = new Dimension(150, 50);

		for (int i = 0; i < continent.length; i++) {
			continent[i].setBackground(backColor[i]);
			continent[i].setForeground(foreColor[i]);
			continent[i].setMinimumSize(size);
			continent[i].setPreferredSize(size);
			continent[i].setMaximumSize(size);
			continent[i].addActionListener(this);
		}

		// ボタンを配置
		Box topBox = new Box(BoxLayout.X_AXIS);
		getContentPane().add(topBox, BorderLayout.NORTH);

		topBox.add(Box.createHorizontalStrut(80));
		topBox.add(continent[0]);
		topBox.add(Box.createHorizontalGlue());
		topBox.add(continent[1]);
		topBox.add(Box.createHorizontalStrut(80));

		Box centerBox = new Box(BoxLayout.X_AXIS);
		getContentPane().add(centerBox, BorderLayout.CENTER);

		centerBox.add(Box.createHorizontalStrut(5));
		centerBox.add(continent[2]);
		centerBox.add(Box.createHorizontalGlue());
		centerBox.add(continent[3]);
		centerBox.add(Box.createHorizontalGlue());
		centerBox.add(continent[4]);
		centerBox.add(Box.createHorizontalStrut(5));

		// 操作を行うボタンを２つ作成
		display = new JButton("表示");
		display.addActionListener(this);

		initialize = new JButton("初期化");
		initialize.addActionListener(this);

		// 操作を行うボタンを配置
		Box bottomBox = new Box(BoxLayout.X_AXIS);
		getContentPane().add(bottomBox, BorderLayout.SOUTH);

		bottomBox.add(Box.createHorizontalStrut(60));
		bottomBox.add(display);
		bottomBox.add(Box.createHorizontalGlue());
		bottomBox.add(initialize);
		bottomBox.add(Box.createHorizontalStrut(60));

		pack();

	}

	public void actionPerformed(ActionEvent e) {

		// 表示ボタンが押されたら、記憶されたテキストをコンソールに表示する
		if (e.getSource().equals(display)) {
			for (int i = 0; i < vector.size(); i++) {
				JButton button = (JButton) vector.get(i);
				System.out.println(button.getText());
			}
		}
		// 初期化ボタンが押されたら、記憶されたテキストを全て消去する
		else if (e.getSource().equals(initialize)) {
			vector.clear();
		}
		// 5つのボタンを押すと、ボタンにかかれたテキストが
		// 「Vector」クラスに押された順に記憶される。
		else {
			for (int i = 0; i < continent.length; i++) {
				if (e.getSource().equals(continent[i])) {
					vector.add(continent[i]);
					break;
				}
			}
		}

	}

	public static void main(String args[]) {
		new VectorExample().setVisible(true);
	}

}