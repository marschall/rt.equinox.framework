/*******************************************************************************
 * Copyright (c) 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.osgi.container.namespaces;

import org.osgi.framework.Constants;
import org.osgi.resource.Namespace;

/**
 * Equinox module data capability namespace.  This namespace is used
 * to store immutable data about a module revision.  This includes the following
 * <ul>
 *   <li>The activation policy as specified by the {@link Constants#BUNDLE_ACTIVATIONPOLICY}
 *       Bundle-ActivationPolicy} header.</li>
 *   <li>The activator as specified by the {@link Constants#BUNDLE_ACTIVATOR Bundle-Activator}
 *       header.</li>
 *   <li>The class path as specified by the {@link Constants#BUNDLE_CLASSPATH Bundle-ClassPath}
 *       header.</li>
 * </ul>
 * Activation 
 * policy capability is provided for informational purposes and 
 * should not be considered as effective by the resolver.
 * <p>
 * For bundles, the attributes of this capability are extracted 
 * from the Bundle-ActivationPolicy header.  The directives
 * {@link Constants#EXCLUDE_DIRECTIVE} and {@link Constants#INCLUDE_DIRECTIVE}
 * are converted to attributes of type {@code List<String>}.
 * 
 * <p>
 * This class defines the names for the attributes and directives for this
 * namespace.  Capabilities in this namespace are not intended to be used to
 * match requirements and should not be considered as effective by a resolver.
 * 
 * @Immutable
 */
public class EquinoxModuleDataNamespace extends Namespace {

	/**
	 * Namespace name for equinox module data.  Unlike typical name spaces
	 * this namespace is not intended to be used as an attribute.
	 */
	public static final String MODULE_DATA_NAMESPACE = "equinox.module.data";

	/**
	 * The directive value identifying a {@link #CAPABILITY_EFFECTIVE_DIRECTIVE
	 * capability} that is effective for information purposes.  Capabilities
	 * in this namespace must have an effective directive value of information.
	 * 
	 * @see #CAPABILITY_EFFECTIVE_DIRECTIVE
	 */
	public final static String EFFECTIVE_INFORMATION = "information";

	/**
	 * The capability attribute contains the {@link Constants#BUNDLE_ACTIVATIONPOLICY 
	 * activation policy} for the providing module revision. The value of this
	 * attribute must be of type {@code String}.  When not specified then
	 * the module revision uses an eager activation policy.
	 */
	public final static String CAPABILITY_ACTIVATION_POLICY = "activation.policy";

	/**
	 * An activation policy name indicating the lazy activation policy
	 * is used.
	 */
	public final static String CAPABILITY_ACTIVATION_POLICY_LAZY = "lazy";

	/**
	 * When the {@link #CAPABILITY_ACTIVATION_POLICY_LAZY lazy} policy is used this 
	 * attribute contains the package names that must
	 * trigger the activation when a class is loaded of these packages.
	 * If the attribute is not defined then the default is all package names. 
	 * The value of this attribute must be of type {@code List<String>}.
	 */
	public final static String CAPABILITY_LAZY_INCLUDE_ATTRIBUTE = "lazy.include";

	/**
	 * When the {@link #CAPABILITY_ACTIVATION_POLICY_LAZY lazy} policy is used this 
	 * attribute contains the package names that must not
	 * trigger the activation when a class is loaded of these packages.
	 * If the attribute is not defined then the default is no package names. 
	 * The value of this attribute must be of type {@code List<String>}.
	 */
	public final static String CAPABILITY_LAZY_EXCLUDE_ATTRIBUTE = "lazy.include";

	/**
	 * The capability attribute contains the {@link Constants#BUNDLE_ACTIVATOR activator}
	 * for the providing module revision.  The value of this attribute must be of type
	 * {@code String}.  When not specified then the module revision has no activator.
	 */
	public final static String CAPABILITY_ACTIVATOR = "activator";

	/**
	 * The capability attribute contains the {@link Constants#BUNDLE_CLASSPATH class path}
	 * for the providing module revision.  The value of this attribute must be of type
	 * {@code List<String>}.  When not specified the module revision uses the default
	 * class path of '.'.
	 */
	public final static String CAPABILITY_CLASSPATH = "classpath";
}