package org.goznak.tools;

import org.springframework.stereotype.Component;

@Component
public class WatchDog {
    private boolean ok = false;
    public boolean isOk() {
        return ok;
    }
    public void setOk(boolean ok) {
        this.ok = ok;
    }
}
