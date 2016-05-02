package org.docksidestage.app;

import org.lastaflute.web.LastaFilter;
import org.lastaflute.web.servlet.filter.LastaToActionFilter;

/**
 * Created by chichi1091 on 2016/05/02.
 */
public class CustomFilter extends LastaFilter {
    @Override
    protected LastaToActionFilter createLastaToActionFilter() {
        return new CustomToActionFilter();
    }
}
