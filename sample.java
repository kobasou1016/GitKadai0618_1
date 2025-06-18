import java.io.FileReader;
import java.io.IOException; // IOExceptionもインポートする

public class sample {
    public static void main(String[] args) {
        FileReader fr = null; // スコープを広げるためにtryの外で宣言
        try {
            // ファイルを開く
            fr = new FileReader("aaa.txt");
            System.out.println("ファイルを開きました。");

            // ファイルから１文字読み込む
            int i = fr.read();

            // 末尾になるまで読み込んで画面出力
            while (i != -1) {
                char c = (char) i;
                System.out.print(c);
                i = fr.read();
            }
        } catch (IOException e) {
            // ファイルが見つからない場合や、読み込みエラーが起きた場合の処理
            System.out.println("エラーが発生しました: " + e.getMessage());
            e.printStackTrace(); // エラーの詳細を出力
        } finally {
            // エラーがあってもなくても、最後に必ず実行される
            try {
                if (fr != null) { // frがnullでないことを確認
                    fr.close(); // ファイルを閉じる
                    System.out.println("\nファイルを閉じました。");
                }
            } catch (IOException e) {
                System.out.println("ファイルを閉じる際にエラーが発生しました。");
                e.printStackTrace();
            }
        }
    }
}
