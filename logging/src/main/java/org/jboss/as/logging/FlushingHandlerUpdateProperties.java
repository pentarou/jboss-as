/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2011, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.jboss.as.logging;

import java.util.logging.Handler;
import static org.jboss.as.logging.CommonAttributes.AUTOFLUSH;
import org.jboss.dmr.ModelNode;
import org.jboss.logmanager.ExtHandler;

/**
 * Parent operation responsible for updating the 'autoflush' property of logging handlers.
 *
 * @author John Bailey
 */
public class FlushingHandlerUpdateProperties extends HandlerUpdateProperties {
    protected void updateModel(final ModelNode operation, ModelNode model) {
        if (operation.hasDefined(AUTOFLUSH)) {
            apply(operation, model, AUTOFLUSH);
        }
    }

    protected void updateRuntime(final ModelNode operation, final Handler handler) {
        if (operation.hasDefined(AUTOFLUSH)) {
            ExtHandler.class.cast(handler).setAutoFlush(operation.get(AUTOFLUSH).asBoolean());
        }
    }
}
