import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
class Version{
	String filename;
	String version;
	int filesize;
	Version(String filename,String version,int filesize){
		this.filename = filename;
		this.version = version;
		this.filesize=filesize;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public int getFilesize() {
		return filesize;
	}
	public void setFilesize(int filesize) {
		this.filesize = filesize;
	}
	void display() {
		System.out.println(filename+" "+version+" "+filesize);
	}
}

class control{
	List<Version> list = new ArrayList<>();
	public void upload(Version version) {
		List<Version> l = list.stream()
		        .filter(e -> e.getFilename().equals(version.getFilename()) &&
		                     e.getVersion().equals(version.getVersion()))
		        .collect(Collectors.toList());

		if(l.size()==0) {
		    list.add(version);
		}
	}
	public void fetch(String filename) {
		List<Version> ll = list.stream()
		        .filter(e->e.getFilename().equals(filename))
		        .sorted(Comparator.comparing(Version::getFilesize)
		        .thenComparing(Version::getVersion))
		        .collect(Collectors.toList());

		if(ll.size()==0){
		    System.out.println("File Not Found");
		    return;
		}
		else{
		    for(Version v : ll){
		        v.display();
		    }
		}		
	}
	public void latest() {
		Version version = list.get(list.size()-1);
		version.display();
	}
	public void total(String filename) {
		int total=0;
		for(Version version : list) {
			if(version.getFilename().equals(filename)) {
				total+=version.getFilesize();
			}
			
		}
		System.out.println(filename+" "+total);
	}
}
public class VersionStorage {
	public static void main(String[] args) {
		control c = new control();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		for(int i=0;i<n;i++) {
			String input = sc.nextLine(); 
			String spl[] = input.split(" ");
			if(spl[0].equals("UPLOAD")) {
				Version v = new Version(spl[1],spl[2],Integer.parseInt(spl[3]));

				c.upload(v);	
			}
			else if(spl[0].equals("FETCH")) {
				c.fetch(spl[1]);
			}
			else if(spl[0].equals("LATEST")) {
				c.latest();
			}
			else if(spl[0].equals("TOTAL_STORAGE")) {
				c.total(spl[1]);
			}
		}
		
		
		
	}
}










