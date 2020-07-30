package org.jetbrains.research.kotlinrminer.decomposition;

import org.jetbrains.kotlin.psi.KtCallExpression;
import org.jetbrains.kotlin.psi.KtElement;
import org.jetbrains.kotlin.psi.KtFile;
import org.jetbrains.kotlin.psi.KtLambdaExpression;
import org.jetbrains.research.kotlinrminer.LocationInfo;
import org.jetbrains.research.kotlinrminer.diff.CodeRange;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AnonymousClassDeclarationObject implements LocationInfoProvider {
    private final String anonName;
    private LocationInfo locationInfo;
    private KtElement elementNode;
    private List<String> variables = new ArrayList<>();
    private List<String> types = new ArrayList<>();
    private Map<String, List<KtCallExpression>> methodInvocationMap = new LinkedHashMap<>();
    private List<VariableDeclaration> variableDeclarations = new ArrayList<>();
    private List<AnonymousClassDeclarationObject> anonymousClassDeclarations = new ArrayList<>();
    private List<String> stringLiterals = new ArrayList<>();
    private List<String> numberLiterals = new ArrayList<>();
    private List<String> nullLiterals = new ArrayList<>();
    private List<String> booleanLiterals = new ArrayList<>();
    private List<String> typeLiterals = new ArrayList<>();
    private List<String> prefixExpressions = new ArrayList<>();
    private List<String> postfixExpressions = new ArrayList<>();
    private List<KtLambdaExpression> lambdas = new ArrayList<>();
    private List<String> arrayAccesses = new ArrayList<>();
    private List<String> arguments = new ArrayList<>();

    public AnonymousClassDeclarationObject(KtFile ktFile, String filePath, KtElement anonymous) {
        this.locationInfo = new LocationInfo(ktFile, filePath, anonymous, LocationInfo.CodeElementType.ANONYMOUS_CLASS_DECLARATION);
        this.elementNode = anonymous;
        this.anonName = anonymous.toString();
    }

    public LocationInfo getLocationInfo() {
        return locationInfo;
    }

    public KtElement getElementNode() {
        return elementNode;
    }

    public void setElementNode(KtElement node) {
        this.elementNode = node;
    }

    public String toString() {
        return anonName;
    }


    public List<VariableDeclaration> getVariableDeclarations() {
        return variableDeclarations;
    }

    public List<String> getTypes() {
        return types;
    }

    public List<AnonymousClassDeclarationObject> getAnonymousClassDeclarations() {
        return anonymousClassDeclarations;
    }

    public List<String> getStringLiterals() {
        return stringLiterals;
    }

    public List<String> getNumberLiterals() {
        return numberLiterals;
    }

    public List<String> getNullLiterals() {
        return nullLiterals;
    }

    public List<String> getBooleanLiterals() {
        return booleanLiterals;
    }

    public List<String> getTypeLiterals() {
        return typeLiterals;
    }

    public List<String> getVariables() {
        return variables;
    }

    public List<String> getPrefixExpressions() {
        return prefixExpressions;
    }

    public List<String> getArrayAccesses() {
        return arrayAccesses;
    }

    public List<String> getPostfixExpressions() {
        return postfixExpressions;
    }

    public List<String> getArguments() {
        return this.arguments;
    }

    public List<KtLambdaExpression> getLambdas() {
        return lambdas;
    }

    public CodeRange codeRange() {
        return locationInfo.codeRange();
    }
}
