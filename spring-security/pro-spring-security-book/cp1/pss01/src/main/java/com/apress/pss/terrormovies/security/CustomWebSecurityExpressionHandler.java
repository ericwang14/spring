package com.apress.pss.terrormovies.security;

import org.springframework.security.access.expression.AbstractSecurityExpressionHandler;
import org.springframework.security.access.expression.SecurityExpressionOperations;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;

/**
 * Created ${name}
 *
 * @author wanggang
 * @since ${Date}
 */
public class CustomWebSecurityExpressionHandler extends AbstractSecurityExpressionHandler<FilterInvocation> {

    @Override
    protected SecurityExpressionOperations createSecurityExpressionRoot(Authentication authentication, FilterInvocation invocation) {
        CustomWebSecurityExpressionRoot expressionRoot = new CustomWebSecurityExpressionRoot(authentication, invocation);
        expressionRoot.setPermissionEvaluator(getPermissionEvaluator());
        expressionRoot.setTrustResolver(new AuthenticationTrustResolverImpl());
        return expressionRoot;
    }
}
