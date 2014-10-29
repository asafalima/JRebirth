/**
 * Get more info at : www.jrebirth.org .
 * Copyright JRebirth.org © 2011-2013
 * Contact : sebastien.bordes@jrebirth.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jrebirth.af.core.resource.font;

import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import org.jrebirth.af.api.resource.builder.ResourceBuilder;
import org.jrebirth.af.api.resource.font.FontItem;
import org.jrebirth.af.api.resource.font.FontName;
import org.jrebirth.af.api.resource.font.FontParams;
import org.jrebirth.af.core.resource.ResourceBuilders;

/**
 * The class <strong>FontItem</strong>.
 *
 * @author Sébastien Bordes
 */
public interface FontItemReal extends FontItem {

    /**
     * {@inheritDoc}
     */
    @Override
    default ResourceBuilder<FontItem, FontParams, Font> builder() {
        return ResourceBuilders.FONT_BUILDER;
    }

    public interface Real extends FontItem {

        /**
         * .
         *
         * @param name
         * @param size
         */
        default void real(final FontName name, final double size) {
            set(new RealFont(name, size));
        }

    }

    public interface Family extends FontItem {

        /**
         * .
         *
         * @param family
         * @param size
         */
        default void family(final String family, final double size) {
            set(new FamilyFont(family, size));
        }

        /**
         *
         * TODO To complete.
         *
         * @param family
         * @param size
         * @param weight
         */
        default void family(final String family, final double size, final FontWeight weight) {
            set(new FamilyFont(family, size, weight));
        }

        /**
         *
         * TODO To complete.
         *
         * @param family
         * @param size
         * @param posture
         */
        default void family(final String family, final double size, final FontPosture posture) {
            set(new FamilyFont(family, size, posture));
        }

        /**
         *
         * TODO To complete.
         *
         * @param family
         * @param size
         * @param weight
         * @param posture
         */
        default void family(final String family, final double size, final FontWeight weight, final FontPosture posture) {
            set(new FamilyFont(family, size, weight, posture));
        }

    }
}