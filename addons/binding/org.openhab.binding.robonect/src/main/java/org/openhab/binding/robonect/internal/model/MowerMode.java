/**
 * Copyright (c) 2010-2018 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.robonect.internal.model;

/**
 * The mower mode from the status information. Please note 
 * that EOD and JOB from {@link org.openhab.binding.robonect.internal.model.cmd.ModeCommand.Mode}
 * are just artificial and are therfore not reported in the status information.
 * 
 * @author Marco Meyer - Initial contribution
 */
public enum MowerMode {

    /**
     * The AUTO mode
     */
    AUTO(0),

    /**
     * The MANUAL mode
     */
    MANUAL(1),

    /**
     * The HOME mode
     */
    HOME(2),

    /**
     * The DEMO mode
     */
    DEMO(3),

    /**
     * An unknown mode. Actually this mode should never be set but is there if for some reason an unexpected value
     * is returned from the module response.
     */
    UNKNOWN(99);

    private int code;

    MowerMode(int code) {
        this.code = code;
    }

    /**
     * Translate the numeric mode from the JSON response into enum values.
     * @param mode - the numeric value of the mode.
     * @return - the enum value of the mode.
     */
    public static MowerMode fromMode(int mode) {
        for (MowerMode mowerMode : MowerMode.values()) {
            if (mowerMode.code == mode) {
                return mowerMode;
            }
        }
        return UNKNOWN;
    }

    /**
     * @return - The numeric code of the mode.
     */
    public int getCode() {
        return code;
    }
  
}
