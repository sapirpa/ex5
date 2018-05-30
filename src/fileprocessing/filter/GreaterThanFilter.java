package fileprocessing.filter;

import java.io.File;

public class GreaterThanFilter implements Filter{
    String[] currentFilter;
    boolean isNotStatement;
    private String GREATER_THAN  = "greater_than";
    private Double lowerBound = Double.parseDouble(currentFilter[1]);

    /**
     * a conatractor
     * @param filter the filter for this
     * @param notStatement
     */
    private GreaterThanFilter(String[] filter, boolean notStatement){
        currentFilter = filter;
        isNotStatement = notStatement;
    }

    @Override
    public boolean isValid() {
        return lowerBound > 0;
    }

    @Override
    public boolean accept(File dir, String name) {
        File currentFile = new File(name);

        if (isValid()) {
            if (!isNotStatement) {
                return currentFile.getTotalSpace()/ CONVERT_TO_K_BYTE > lowerBound ;
            } else {
                return !(currentFile.getTotalSpace()/ CONVERT_TO_K_BYTE > lowerBound );
            }
        }
        return false;
    }

    @Override
    public boolean equals(String toCompare) {
        return false;
    }
}
