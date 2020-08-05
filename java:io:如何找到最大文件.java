package IO;

import java.io.File;


//如何找到指定文件夹中最大的文件和最小的文件
public class file {
	static File max;
	static File min;
	static long max_length = 0;
	static long min_length = 2147283647;
	public static void main(String[] args) {


		//指定根目录
		File root = new File("/Users/xieyu/Desktop/学习资料/文献");
		//System.out.println(root.getAbsolutePath());
		//System.out.println(root.exists());
		file.search(root);
		System.out.println(max);
		System.out.println(min);
		
	}
	

	public static void search(File f) {
		//如果f是文件夹，递归寻找
		if(f.isDirectory()) {
			File[] fs= f.listFiles();
			for(File each : fs) {
				search(each);
			}	
		}

		//如果f是文件，比较并更新大小
		if(f.isFile()) {
			if(f.length() > max_length) {
				max_length = f.length();
				max = f;
			}
			if(f.length() <= min_length) {
				min_length = f.length();
				min = f;
			}
		}
		
	}

}
