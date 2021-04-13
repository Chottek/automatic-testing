package pl.fox.lab5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class APIBuilder {

    private static final Logger LOG = LoggerFactory.getLogger(APIBuilder.class);

    private String site;
    private String protocol;
    private List<String> subsites = new ArrayList<>();
    private Map<String, String> args = new HashMap<>();

    public APIBuilder withHTTP() {
        this.protocol = "http://";
        return this;
    }

    public APIBuilder withHTTPS() {
        this.protocol = "https://";
        return this;
    }

    public APIBuilder withSite(String site) {
        this.site = site;
        return this;
    }

    public APIBuilder withSubsite(String subsite){
        subsites.add(subsite);
        return this;
    }

    public APIBuilder withParam(String param, String value) {
        args.put(args.size() == 0 ? "?" + param : "&" + param,  "=" + value);
        return this;
    }

    public APIBuilder withCleanParam(String param){
        args.put(param, "");
        return this;
    }

    public String getFinalURL() {
        LOG.info("Building URL String");
        StringBuilder sb = new StringBuilder();
        sb.append(protocol).append(site).append("/");
        LOG.info("Merged {} and {}", protocol, site);

        if(subsites.size() != 0){
            subsites.forEach(subsite -> sb.append(subsite).append("/"));
            LOG.info("Added subsites: {}", subsites.toString());
        }

        if(args.size() != 0){
            args.keySet().forEach(param -> sb.append(param).append(args.get(param)));
            LOG.info("Added params: {}", args.toString());
        }

        LOG.info("Got {}", sb.toString());
        return sb.toString();
    }
}
