package member1;

public class MemberService1{
	private FileService1 fs;
	public MemberService1(){
		fs = new FileService1();
	}
	public void save(Member1DTO dto) {
		fs.inputData(dto);
	}
	public boolean checkUser(String name) {
		return fs.checkuser(name);
	}
	public Member1DTO getMember(String name) {
		return fs.readData(name);
	}
}
