package com.luv.util.constant;

import static com.luv.util.constant.MiscellaneousConstants.API_VERSION;

public class AuthConstants {
    public static final String[] AUTH_IGNORED_PATHS = {
            API_VERSION + "/auth/login",
            API_VERSION + "/auth/signup"

    };
    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String BEARER_PREFIX = "Bearer ";//Also contains the space b/w Bearer & token
    public static final int BEARER_PREFIX_LENGTH = 7;
    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60 * 1000;//5hrs in milliseconds TODO: reduce this time & use refreshToken approach

}
