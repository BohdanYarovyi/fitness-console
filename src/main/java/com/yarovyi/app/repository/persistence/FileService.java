package com.yarovyi.app.repository.persistence;

import java.io.File;
import java.io.IOException;

public interface FileService {

    String readFile(File file) throws IOException;
    void writeToFile(String content, File file) throws IOException;

}
