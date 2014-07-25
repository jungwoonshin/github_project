//package git.repository;
//
//import javax.json.Json;
//import javax.json.JsonObject;
//import javax.json.JsonObjectBuilder;
//
//import org.apache.commons.lang3.RandomStringUtils;
//
//import com.jcabi.github.Content;
//import com.jcabi.github.Coordinates;
//import com.jcabi.github.Github;
//import com.jcabi.github.Repo;
//import com.jcabi.github.RtGithub;
//
//public class Test02_delete_repository{
//	//	static Logger logger;
//	static String user = "jungwoonshin";
//	static String password = "wjddns1025";
//
//
//	public static void main(String[] args) throws Exception {
//		Github github = new RtGithub("jungwoonshin","wjddns1025");
//		Coordinates.Simple repositoryToBeRemoved = new Coordinates.Simple(user,"bit-0601-0901");
////		Coordinates.Simple repositoryToBeRemoved1 = new Coordinates.Simple(user,"shinjungwoon4");
////		Coordinates.Simple repositoryToBeRemoved2 = new Coordinates.Simple(user,"shinjungwoon5");
//		Repo repo = github.repos().get(repositoryToBeRemoved);
//		System.out.println("=================================================================================");
//		
//		//리파지토리 삭제하기
//		github.repos().remove(repositoryToBeRemoved);
////		github.repos().remove(repositoryToBeRemoved1);
////		github.repos().remove(repositoryToBeRemoved2);
//		
//	}
//
//
//    /**
//     * Generate a random fake SHA hex string.
//     *
//     * @return Fake SHA string.
//     */
//    private static String fakeSha() {
//        // @checkstyle MagicNumberCheck (1 line)
//        return RandomStringUtils.random(40, "0123456789abcdef");
//    }
//}