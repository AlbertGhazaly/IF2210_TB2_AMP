package entity;

import java.io.File;
import java.io.IOException;

public interface Entity {
    public void save(String path) throws IOException;
    public void load(String path) throws IOException ;
}
