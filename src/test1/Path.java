package test1;

import java.io.File;

/**
 * Created by 锦 on 2015/4/4.
 */
public class Path {
    FolderNode Node;
    File theFile;
    public Path(FolderNode Node){
        this.Node = Node;
        theFile = Node.getTheFile();
    }
    public String getFilePath(){
        return theFile.getPath();
    }
}
