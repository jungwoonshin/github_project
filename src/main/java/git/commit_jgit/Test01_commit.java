package git.commit_jgit;

import java.io.IOException;

import javax.json.JsonArray;
import javax.json.JsonObject;

import org.apache.commons.codec.binary.Base64;

import com.jcabi.github.Coordinates;
import com.jcabi.github.Github;
import com.jcabi.github.Repo;
import com.jcabi.github.RtGithub;
import com.jcabi.github.Tree;

public class Test01_commit {


	public static void main(String[] args) throws IOException {
		Github github = new RtGithub("jungwoonshin","**");
		Repo repo = github.repos().get(
				new Coordinates.Simple("jungwoonshin","pull_test")
				);

		byte[] encodedBytes = Base64.encodeBase64("creating file at desired destination".getBytes());
		byte[] encodedBytes_korean = Base64.encodeBase64("한글폴더".getBytes());
		byte[] decodedBytes = Base64.decodeBase64(encodedBytes);

		//		repo.contents().create(Json.createObjectBuilder()
		//				.add("path","/create_folder2")
		//				.add("message","successfully created folder")
		//				.add("content",new String(encodedBytes))
		//				.build());

		//		repo.contents().create(Json.createObjectBuilder()
		//				.add("path","/folder2/folder3")
		//				.add("message","successfully korean created folder")
		//				.add("content",new String(encodedBytes_korean))
		//				.build());

		//		repo.releases().create("realeases");
		//		System.out.println(3);



		//			be2c7ab1491a0e7a0b39246ecc70b9148ea32c92

		//			JsonObject author = Json.createObjectBuilder().add("name","jungwoon").add("email","jungwoonshin@gmail.com")
		//					.add("date","2014-08-05T16:13:30+12:00").build();
		//			JsonArray tree = Json.createArrayBuilder().add("ddd57bd80e16027ca7c8aaa13c42d46ac458ec32").build();
		//			repo.git().trees().create(Json.createObjectBuilder().add("sha","ddd57bd80e16027ca7c8aaa13c42d46ac458ec32").build());
		//			
		//			Commit newCommit = repo.git().commits().create( Json.createObjectBuilder()
		//					.add("sha", "12ahscba")
		//					.add("tree", "be2c7ab1491a0e7a0b39246ecc70b9148ea32c92")
		//					.add("parents", tree)
		//					.add("author", author)
		//					.add("message", "my commit !!! message")
		//					.build()
		//			);

		Tree tree = repo.git().trees().get("219775c3bc81928fd05853b56c5cb1c28cd26cd3");
		JsonObject jsonTree = tree.json();

		String sha_of_tree = jsonTree.getString("sha");
		String url_of_tree = jsonTree.getString("url");


		System.out.println("sha_of_tree: " + sha_of_tree);
		System.out.println("url_of_tree: " + url_of_tree);

		String url_of_commit = repo.git().commits().get("be2c7ab1491a0e7a0b39246ecc70b9148ea32c92").json().getString("url");
		System.out.println("url_of_commit:" + url_of_commit);

		
		String name_of_repo = repo.json().getString("name");
		System.out.println("name_of_repo: " + name_of_repo);

		String url_of_repo = repo.git().repo().json().getString(("url"));
		System.out.println("url_of_repo: " + url_of_repo);
		
		
		JsonArray jarray_of_repo_commits = repo.commits().json().getJsonArray("commits");
		
//		for(int i=0; i<jarray_of_repo_commits)
//		jarray_of_repo_commits.getJsonObject(0);
		
		
//		Have you tried using JSONArray.getJSONObject(int), and JSONArray.length() to create your for-loop:
//
//			for (int i = 0; i < recs.length(); ++i) {
//			    JSONObject rec = recs.getJSONObject(i);
//			    int id = rec.getInt("id");
//			    String loc = rec.getString("loc");
//			    // ...
//			}
//		
		//Get all the commits of a repository


		//			System.out.println(pull_json.getString("master"));
		System.out.println("complete");







	}

}
