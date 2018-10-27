package pl.kodu.akademia.NoteAplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private String resurceName;
    private String fileName;
    private Object fileValue;

    private ResourceNotFoundException(String resurceName, String fileName, Object fileValue){

        super(String.format("%s not fund with %s : '%s'", resurceName, fileName, fileValue));
        this.resurceName = resurceName;
        this.fileName = fileName;
        this.fileValue = fileValue;

    }

    public String getResurceName() {
        return resurceName;
    }

    public String getFileName() {
        return fileName;
    }

    public Object getFileValue() {
        return fileValue;
    }
}
