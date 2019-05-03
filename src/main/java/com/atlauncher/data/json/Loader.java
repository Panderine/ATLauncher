/*
 * ATLauncher - https://github.com/ATLauncher/ATLauncher
 * Copyright (C) 2013 ATLauncher
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package com.atlauncher.data.json;

import com.atlauncher.annot.Json;
import com.atlauncher.workers.InstanceInstaller;

import java.io.File;

@Json
public class Loader {
    private String type;
    private String version;
    private String yarn;
    private String loader;
    private boolean latest;
    private boolean recommended;
    private String minecraft;
    private String className;

    public String getType() {
        return this.type;
    }

    public String getVersion() {
        return this.version;
    }

    public String getMinecraft() {
        return this.minecraft;
    }

    public String getClassName() {
        return this.className;
    }

    public com.atlauncher.data.loaders.Loader getLoader(File tempDir, InstanceInstaller instanceInstaller)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        com.atlauncher.data.loaders.Loader instance = (com.atlauncher.data.loaders.Loader) Class.forName(this.className)
                .newInstance();

        instance.set(this.version, this.minecraft, this.yarn, this.loader, this.latest, this.recommended, tempDir,
                instanceInstaller);

        return instance;
    }
}