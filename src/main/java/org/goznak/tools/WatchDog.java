package org.goznak.tools;

import org.springframework.stereotype.Component;

@Component
public class WatchDog {
    private boolean ok = false;
    public synchronized boolean isOk() {
        return ok;
    }
    public synchronized void setOk(boolean ok) {
        this.ok = ok;
    }
}
