/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial.action;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.StreamingResolution;
import net.sourceforge.stripes.validation.SimpleError;
import net.sourceforge.stripes.validation.Validate;

/**
 *
 * @author hantsy
 */
public class DownloadActionBean extends BaseActionBean {

    @Validate(required=true)
    private String filename;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Resolution download() {
        return new StreamingResolution("application/octet-stream", buildDowloadSource()).setFilename(filename);
    }

    public InputStream buildDowloadSource() {
        String rootPath = getContext().getServletContext().getRealPath("/");
        String filePath = rootPath + "/public/Fedora.png";
        try {
            return new FileInputStream(filePath);
        } catch (FileNotFoundException ex) {
            getContext().getValidationErrors().addGlobalError(new SimpleError("Can not found file!"));
        }
        return null;
    }
}
