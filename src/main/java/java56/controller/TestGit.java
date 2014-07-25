package java56.controller;

import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.api.CreateBranchCommand.SetupUpstreamMode;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.CanceledException;
import org.eclipse.jgit.api.errors.ConcurrentRefUpdateException;
import org.eclipse.jgit.api.errors.DetachedHeadException;
import org.eclipse.jgit.api.errors.InvalidConfigurationException;
import org.eclipse.jgit.api.errors.InvalidRefNameException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.api.errors.NoFilepatternException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.eclipse.jgit.api.errors.NoMessageException;
import org.eclipse.jgit.api.errors.RefAlreadyExistsException;
import org.eclipse.jgit.api.errors.RefNotFoundException;
import org.eclipse.jgit.api.errors.WrongRepositoryStateException;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.Repository;
import org.springframework.stereotype.Controller;

@Controller
public class TestGit {

    private String localPath, remotePath;
    private Repository localRepo;
    private Git git;

    public void init() throws IOException {
        localPath = "/home/me/repos/mytest";
        remotePath = "git@github.com:jungwoonshin/mytestrepo.git";
        localRepo = new FileRepository(localPath + "/.git");
        git = new Git(localRepo);
    }

    public void testCreate() throws IOException {
        Repository newRepo = new FileRepository(localPath + ".git");
        newRepo.create();
    }

    public void testClone() throws Exception, NoFilepatternException {
        Git.cloneRepository().setURI(remotePath)
            .setDirectory(new File(localPath)).call();
    }
    public void testAdd() throws Exception, NoFilepatternException {
        File myfile = new File(localPath + "/myfile");
        myfile.createNewFile();
        git.add().addFilepattern("myfile").call();
    }

    public void testCommit() throws Exception, NoHeadException,
            NoMessageException, ConcurrentRefUpdateException,
            JGitInternalException, WrongRepositoryStateException {
        git.commit().setMessage("Added myfile").call();
    }

    public void testPush() throws Exception, JGitInternalException,
            InvalidRemoteException {
        git.push().call();
    }
    public void testTrackMaster() throws Exception, JGitInternalException,
            RefAlreadyExistsException, RefNotFoundException,
            InvalidRefNameException {
        git.branchCreate().setName("master")
            .setUpstreamMode(SetupUpstreamMode.SET_UPSTREAM)
            .setStartPoint("origin/master").setForce(true).call();
    }

    public void testPull() throws Exception, WrongRepositoryStateException,
            InvalidConfigurationException, DetachedHeadException,
            InvalidRemoteException, CanceledException, RefNotFoundException,
            NoHeadException {
        git.pull().call();
    }
}