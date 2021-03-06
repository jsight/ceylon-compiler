package com.redhat.ceylon.compiler.java.test.expression;

import org.junit.Ignore;
import org.junit.Test;

import com.redhat.ceylon.compiler.java.test.CompilerTest;

public class ExpressionTest2 extends CompilerTest {
    
    @Override
    protected String transformDestDir(String name) {
        return name + "-2";
    }

    // Method invocation

    @Test
    public void testInvAnonymousFunctionPositionalInvocation(){
        compareWithJavaSource("invoke/AnonymousFunctionPositionalInvocation");
    }
    @Test
    public void testInvAnonymousFunctionPositionalInvocation2(){
        compareWithJavaSource("invoke/AnonymousFunctionPositionalInvocation2");
    }
    @Test
    public void testInvMethodArgumentNamedInvocation(){
        compareWithJavaSource("invoke/MethodArgumentNamedInvocation");
    }
    @Test
    public void testInvMethodArgumentNamedInvocationVoid(){
        compareWithJavaSource("invoke/MethodArgumentNamedInvocationVoid");
    }
    @Test
    public void testInvMethodArgumentNamedInvocation2(){
        compareWithJavaSource("invoke/MethodArgumentNamedInvocation2");
    }
    
    @Test
    public void testInvObjectArgumentNamed(){
        compareWithJavaSource("invoke/ObjectArgumentNamedInvocation");
    }
    
    @Test
    public void testInvObjectArgumentNamedInvocation(){
        compareWithJavaSource("invoke/ObjectArgumentNamedInvocation");
    }
    
    @Test
    public void testInvObjectArgumentNamedInvocationChained(){
        compareWithJavaSource("invoke/ObjectArgumentNamedInvocationChained");
        compileAndRun("com.redhat.ceylon.compiler.java.test.expression.invoke.objectArgumentNamedInvocationChained", "invoke/ObjectArgumentNamedInvocationChained.ceylon");
    }
    
    @Test
    public void testInvGetterArgumentNamedInvocation(){
        compareWithJavaSource("invoke/GetterArgumentNamedInvocation");
    }
    
    @Test
    public void testInvGetterArgumentNamedInvocationGeneric(){
        compareWithJavaSource("invoke/GetterArgumentNamedInvocationGeneric");
    }
    
    @Test
    public void testInvChainedInvocations(){
        compareWithJavaSource("invoke/ChainedInvocations");
    }

    @Test
    public void testInvGenericMethodInvocation(){
        compareWithJavaSource("invoke/GenericMethodInvocation");
    }
    
    @Test
    public void testInvGenericMethodInvocationMixed(){
        compareWithJavaSource("invoke/GenericMethodInvocationMixed");
    }

    @Test
    public void testInvInnerMethodInvocation(){
        compareWithJavaSource("invoke/InnerMethodInvocation");
    }

    @Test
    public void testInvInvocationErasure(){
        compareWithJavaSource("invoke/InvocationErasure");
    }
    
    @Test
    public void testInvMethodInvocation(){
        compareWithJavaSource("invoke/MethodInvocation");
    }

    @Test
    public void testInvMethodInvocationWithDefaultedParameters(){
        compareWithJavaSource("invoke/MethodInvocationWithDefaultedParameters");
    }

    @Test
    @Ignore("Not for needed for M1")
    public void testInvNamedArgumentGetterInvocation(){
        compareWithJavaSource("invoke/NamedArgumentGetterInvocation");
    }

    @Test
    public void testInvNamedArgumentInvocation(){
        compareWithJavaSource("invoke/NamedArgumentInvocation");
    }
    
    @Test
    public void testInvNamedArgumentNoArgs(){
        compareWithJavaSource("invoke/NamedArgumentNoArgs");
    }
    
    @Test
    public void testInvNamedArgumentInvocationInit(){
        compareWithJavaSource("invoke/NamedArgumentInvocationInit");
    }
    
    @Test
    public void testInvNamedArgumentInvocationTopLevel(){
        compareWithJavaSource("invoke/NamedArgumentInvocationTopLevel");
    }
    
    @Test
    public void testInvNamedArgumentInvocationLocal(){
        compareWithJavaSource("invoke/NamedArgumentInvocationLocal");
    }
    @Test
    public void testInvNamedArgumentWithSequence(){
        compareWithJavaSource("invoke/NamedArgumentWithSequence");
    }
    
    @Test
    public void testInvNamedArgumentWithEmptySequence(){
        compareWithJavaSource("invoke/NamedArgumentWithEmptySequence");
    }
    
    @Test
    public void testInvNamedArgumentInvocationInitWithSequence(){
        compareWithJavaSource("invoke/NamedArgumentInvocationInitWithSequence");
    }
    
    @Test
    public void testInvNamedArgumentInvocationWithDefaultedSequence(){
        compareWithJavaSource("invoke/NamedArgumentInvocationWithDefaultedSequence");
    }
    
    @Test
    public void testInvNamedArgumentInvocationInitWithEmptySequence(){
        compareWithJavaSource("invoke/NamedArgumentInvocationInitWithEmptySequence");
    }
    
    @Test
    public void testInvNamedArgumentInvocationOnPrimitive(){
        compareWithJavaSource("invoke/NamedArgumentInvocationOnPrimitive");
    }
    
    @Test
    public void testInvNamedArgumentSequencedTypeParamInvocation(){
        compareWithJavaSource("invoke/NamedArgumentSequencedTypeParamInvocation");
    }
    
    @Test
    public void testInvSequencedParameterInvocation(){
        compareWithJavaSource("invoke/SequencedParameterInvocation");
    }
    
    @Test
    public void testInvSequencedTypeParamInvocation(){
        compareWithJavaSource("invoke/SequencedTypeParamInvocation");
    }
    
    @Test
    public void testInvSequencedTypeParamInvocation2(){
        compareWithJavaSource("invoke/SequencedTypeParamInvocation2");
    }
    
    @Test
    public void testInvZeroSequencedArgs(){
        compareWithJavaSource("invoke/ZeroSequencedArgs");
    }
    
    @Test
    public void testInvDefaultedAndSequenced(){
        compareWithJavaSource("invoke/DefaultedAndSequencedParams");
    }
    @Test
    public void testInvDefaultedAndTypeParams(){
        compareWithJavaSource("invoke/DefaultedAndTypeParams");
    }

    @Test
    public void testInvToplevelMethodInvocation(){
        compareWithJavaSource("invoke/ToplevelMethodInvocation");
    }

    @Test
    public void testInvToplevelMethodWithDefaultedParams(){
        compareWithJavaSource("invoke/ToplevelMethodWithDefaultedParams");
    }
    
    @Test
    public void testInvOptionalTypeParamArgument(){
        compareWithJavaSource("invoke/OptionalTypeParamArgument");
    }
    
    @Test
    public void testCallableAndDefaultedArguments(){
        compile("invoke/CallableAndDefaultedArguments_foo.ceylon");
        compareWithJavaSource("invoke/CallableAndDefaultedArguments_bar");
    }
    
    @Test
    public void testCallableArgumentWithDefaultedArguments(){
        compareWithJavaSource("invoke/CallableArgumentWithDefaulted");
        // Note we want to run it as well, because one of the problems 
        // is not found at compile time (#512)
        compileAndRun("com.redhat.ceylon.compiler.java.test.expression.invoke.callableArgumentWithDefaulted_main", 
                "invoke/CallableArgumentWithDefaulted");
    }
    
    @Test
    public void testCallableArgumentNullary(){
        compareWithJavaSource("invoke/CallableArgumentNullary");
    }
    
    @Test
    public void testCallableArgumentUnary(){
        compareWithJavaSource("invoke/CallableArgumentUnary");
    }
    
    @Test
    public void testCallableArgumentBinary(){
        compareWithJavaSource("invoke/CallableArgumentBinary");
    }
    
    @Test
    public void testCallableArgumentTernary(){
        compareWithJavaSource("invoke/CallableArgumentTernary");
    }
    
    @Test
    public void testCallableArgumentNary(){
        compareWithJavaSource("invoke/CallableArgumentNary");
    }
    
    @Test
    public void testCallableArgumentSequenced(){
        compareWithJavaSource("invoke/CallableArgumentSequenced");
    }
    @Test
    public void testCallableArgumentVarargs(){
        compareWithJavaSource("invoke/CallableArgumentVarargs");
    }
    @Test
    public void testCallableArgumentVarargs2(){
        compareWithJavaSource("invoke/CallableArgumentVarargs2");
    }
    
    @Test
    public void testCallableArgumentParameterClass(){
        compareWithJavaSource("invoke/CallableArgumentParameterClass");
    }
    
    @Test
    public void testCallableArgumentParameterQualified(){
        compareWithJavaSource("invoke/CallableArgumentParameterQualified");
    }
    
    @Test
    public void testCallableArgumentParameterTypeParam(){
        compareWithJavaSource("invoke/CallableArgumentParameterTypeParam");
    }
    
    @Test
    public void testCallableArgumentParameterTypeParamMixed(){
        compareWithJavaSource("invoke/CallableArgumentParameterTypeParamMixed");
    }
    
    @Test
    @Ignore("Awaiting support for parameter bounds")
    public void testCallableArgumentParameterCtor(){
        compareWithJavaSource("invoke/CallableArgumentParameterCtor");
    }
    
    @Test
    public void testCallableArgumentPassed(){
        compareWithJavaSource("invoke/CallableArgumentPassed");
    }
    
    @Test
    public void testCallableArgumentReturningInteger(){
        compareWithJavaSource("invoke/CallableArgumentReturningInteger");
    }
    
    @Test
    public void testCallableArgumentReturningClass(){
        compareWithJavaSource("invoke/CallableArgumentReturningClass");
    }
    
    @Test
    public void testCallableArgumentReturningQualifiedClass(){
        compareWithJavaSource("invoke/CallableArgumentReturningQualifiedClass");
    }
    
    @Test
    public void testCallableArgumentReturningTypeParam(){
        compareWithJavaSource("invoke/CallableArgumentReturningTypeParam");
    }
    
    @Test
    public void testCallableReturnNullary(){
        compareWithJavaSource("invoke/CallableReturnNullary");
    }
    
    @Test
    public void testCallableReturnUnary(){
        compareWithJavaSource("invoke/CallableReturnUnary");
    }
    
    @Test
    public void testCallableReturnBinary(){
        compareWithJavaSource("invoke/CallableReturnBinary");
    }
    
    @Test
    public void testCallableReturnTernary(){
        compareWithJavaSource("invoke/CallableReturnTernary");
    }
    
    @Test
    public void testCallableReturnNary(){
        compareWithJavaSource("invoke/CallableReturnNary");
    }
    
    @Test
    public void testCallableReturnCallable(){
        compareWithJavaSource("invoke/CallableReturnCallable");
    }
    
    @Test
    public void testCallableReturnMethod(){
        compareWithJavaSource("invoke/CallableReturnMethod");
    }
    
    @Test
    public void testCallableReturnReturningInteger(){
        compareWithJavaSource("invoke/CallableReturnReturningInteger");
    }
    
    @Test
    public void testCallableReturnReturningClass(){
        compareWithJavaSource("invoke/CallableReturnReturningClass");
    }
    
    @Test
    public void testCallablePositionalInvocationNullary(){
        compareWithJavaSource("invoke/CallablePositionalInvocationNullary");
    }
    
    @Test
    public void testCallablePositionalInvocationUnary(){
        compareWithJavaSource("invoke/CallablePositionalInvocationUnary");
    }
    
    @Test
    public void testCallableCapture(){
        compareWithJavaSource("invoke/CallableCapture");
    }
    
    @Test
    public void testCallablePositionalInvocationAndReturn(){
        compareWithJavaSource("invoke/CallablePositionalInvocationAndReturn");
    }
    
    @Test
    public void testCallablePositionalInvocationSequenced(){
        compareWithJavaSource("invoke/CallablePositionalInvocationSequenced");
    }
    
    @Test
    public void testCallablePositionalInvocationQualified(){
        compareWithJavaSource("invoke/CallablePositionalInvocationQualified");
    }
    
    @Test
    public void testCallableNamedInvocationNullary(){
        compareWithJavaSource("invoke/CallableNamedInvocationNullary");
    }
    
    @Test
    public void testCallableNamedInvocationUnary(){
        compareWithJavaSource("invoke/CallableNamedInvocationUnary");
    }
    
    @Test
    public void testCallableNamedInvocationBinary(){
        compareWithJavaSource("invoke/CallableNamedInvocationBinary");
    }
    
    @Test
    public void testCallableNamedInvocationNary(){
        compareWithJavaSource("invoke/CallableNamedInvocationNary");
    }
    
    @Test
    public void testCallableNamedInvocationSequenced(){
        compareWithJavaSource("invoke/CallableNamedInvocationSequenced");
    }
    
    @Test
    public void testIndirectInvoke(){
        compareWithJavaSource("invoke/IndirectInvoke");
    }
    
    @Test
    public void testIndirectTypeParam(){
        compareWithJavaSource("invoke/IndirectTypeParam");
    }
    
    @Test
    public void testDefaultFunctionReference(){
        compareWithJavaSource("invoke/DefaultFunctionReference");
    }

}
