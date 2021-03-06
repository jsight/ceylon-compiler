/*
 * Copyright Red Hat Inc. and/or its affiliates and other contributors
 * as indicated by the authors tag. All rights reserved.
 *
 * This copyrighted material is made available to anyone wishing to use,
 * modify, copy, or redistribute it subject to the terms and conditions
 * of the GNU General Public License version 2.
 * 
 * This particular file is subject to the "Classpath" exception as provided in the 
 * LICENSE file that accompanied this code.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT A
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE.  See the GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License,
 * along with this distribution; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA  02110-1301, USA.
 */

package com.redhat.ceylon.compiler.loader.impl.reflect.mirror;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.redhat.ceylon.compiler.loader.mirror.AnnotationMirror;
import com.redhat.ceylon.compiler.loader.mirror.ClassMirror;
import com.redhat.ceylon.compiler.loader.mirror.FieldMirror;
import com.redhat.ceylon.compiler.loader.mirror.MethodMirror;
import com.redhat.ceylon.compiler.loader.mirror.PackageMirror;
import com.redhat.ceylon.compiler.loader.mirror.TypeMirror;
import com.redhat.ceylon.compiler.loader.mirror.TypeParameterMirror;

public class ReflectionClass implements ClassMirror {

    private Class<?> klass;
    private ArrayList<FieldMirror> fields;
    private ArrayList<MethodMirror> methods;
    private ArrayList<TypeMirror> interfaces;
    private List<TypeParameterMirror> typeParameters;
    private ReflectionPackage pkg;
    private boolean superClassSet;
    private ReflectionType superClass;
    private LinkedList<ClassMirror> innerClasses;

    public ReflectionClass(Class<?> klass) {
        this.klass = klass;
    }

    @Override
    public AnnotationMirror getAnnotation(String type) {
        return ReflectionUtils.getAnnotation(klass, type);
    }

    @Override
    public boolean isPublic() {
        return Modifier.isPublic(klass.getModifiers());
    }

    @Override
    public String getQualifiedName() {
        return klass.getName();
    }

    @Override
    public String getSimpleName() {
        return klass.getSimpleName();
    }

    @Override
    public PackageMirror getPackage() {
        if(pkg != null)
            return pkg;
        pkg = new ReflectionPackage(klass.getPackage());
        return pkg;
    }

    @Override
    public boolean isInterface() {
        return klass.isInterface();
    }

    @Override
    public boolean isAbstract() {
        return Modifier.isAbstract(klass.getModifiers());
    }

    @Override
    public boolean isStatic() {
        return Modifier.isStatic(klass.getModifiers());
    }

    @Override
    public List<MethodMirror> getDirectMethods() {
        if(methods != null)
            return methods;
        Method[] directMethods = klass.getDeclaredMethods();
        Constructor<?>[] directConstructors = klass.getDeclaredConstructors();
        methods = new ArrayList<MethodMirror>(directMethods.length + directConstructors.length);
        for(Method directMethod : directMethods){
            if(!directMethod.isSynthetic())
                methods.add(new ReflectionMethod(directMethod));
        }
        for(Constructor<?> directConstructor : directConstructors){
            if(!directConstructor.isSynthetic())
                methods.add(new ReflectionMethod(directConstructor));
        }
        return methods;
    }

    @Override
    public List<FieldMirror> getDirectFields() {
        if(fields != null)
            return fields;
        Field[] directFields = klass.getDeclaredFields();
        fields = new ArrayList<FieldMirror>(directFields.length);
        for(Field field : directFields)
            fields.add(new ReflectionField(field));
        return fields;
    }

    @Override
    public TypeMirror getSuperclass() {
        if(superClassSet)
            return superClass;
        Type sup = klass.getGenericSuperclass();
        if(sup != null)
            superClass = new ReflectionType(sup);
        superClassSet = true;
        return superClass;
    }

    @Override
    public List<TypeMirror> getInterfaces() {
        if(interfaces != null)
            return interfaces;
        Type[] javaInterfaces = klass.getGenericInterfaces();
        interfaces = new ArrayList<TypeMirror>(javaInterfaces.length);
        for(Type javaInterface : javaInterfaces)
            interfaces.add(new ReflectionType(javaInterface));
        return interfaces;
    }

    @Override
    public List<TypeParameterMirror> getTypeParameters() {
        if(typeParameters != null)
            return typeParameters;
        typeParameters = ReflectionUtils.getTypeParameters(klass);
        return typeParameters;
    }

    @Override
    public boolean isCeylonToplevelAttribute() {
        return !isInnerClass() && klass.isAnnotationPresent(com.redhat.ceylon.compiler.java.metadata.Attribute.class);
    }

    @Override
    public boolean isCeylonToplevelObject() {
        return !isInnerClass() && klass.isAnnotationPresent(com.redhat.ceylon.compiler.java.metadata.Object.class);
    }

    @Override
    public boolean isCeylonToplevelMethod() {
        return !isInnerClass() && klass.isAnnotationPresent(com.redhat.ceylon.compiler.java.metadata.Method.class);
    }

    @Override
    public boolean isLoadedFromSource() {
        return false;
    }

    @Override
    public String toString() {
        return "[ReflectionClass: "+klass.toString()+"]";
    }

    @Override
    public boolean isInnerClass() {
        return klass.isMemberClass();
    }

    @Override
    public List<ClassMirror> getDirectInnerClasses() {
        if(innerClasses == null){
            innerClasses = new LinkedList<ClassMirror>();
            for(Class<?> innerClass : klass.getDeclaredClasses()){
                innerClasses.add(new ReflectionClass(innerClass));
            }
        }
        return innerClasses;
    }

    @Override
    public boolean isAnonymous() {
        return klass.isAnonymousClass();
    }

    @Override
    public boolean isJavaSource() {
        return false;
    }
}
