package fileprocessing.filter;

import java.io.FilenameFilter;

public interface Filter extends FilenameFilter {
    static final long CONVERT_TO_K_BYTE = 1024;

    boolean isValid();

    boolean equals(String toCompare);
}

