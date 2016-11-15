package org.springframework.cloud.deployer.spi.openshift;

public interface OpenShiftDeploymentPropertyKeys {

	/**
	 * If true, will force an OpenShift {@link io.fabric8.openshift.api.model.Build} for application
	 * and ignore existing Builds
	 */
	String OPENSHIFT_BUILD_FORCE = "spring.cloud.deployer.openshift.forceBuild";

	/**
	 * OpenShift {@link io.fabric8.kubernetes.api.model.ServiceAccount} that containers should run
	 * under. See https://docs.openshift.org/latest/dev_guide/service_accounts.html
	 */
	String OPENSHIFT_DEPLOYMENT_SERVICE_ACCOUNT = "spring.cloud.deployer.openshift.deployment.service.account";

	/**
	 * The Docker image tag used when creating a
	 * {@link io.fabric8.openshift.api.model.DeploymentConfig} with a
	 * {@link io.fabric8.openshift.api.model.ImageChangeTrigger} trigger.
	 */
	String OPENSHIFT_DEPLOYMENT_IMAGE_TAG = "spring.cloud.deployer.openshift.image.tag";

	/**
	 * An inline Dockerfile that will be used as the build input. This Dockerfile will override all
	 * other Dockerfile usage strategies. See
	 * https://docs.openshift.org/latest/dev_guide/builds.html#dockerfile-source
	 */
	String OPENSHIFT_DEPLOYMENT_DOCKERFILE = "spring.cloud.deployer.openshift.deployment.dockerfile";

	/**
	 * An optional nodeSelector to indicate where to schedule pods. All of the following are valid:
	 * <code>spring.cloud.deployer.openshift.deployment.nodeSelector=region: primary,role:processor,label : something</code>
	 * See https://docs.openshift.org/latest/dev_guide/deployments.html#assigning-pods-to-
	 * specific-nodes
	 */
	String OPENSHIFT_DEPLOYMENT_NODE_SELECTOR = "spring.cloud.deployer.openshift.deployment.nodeSelector";

	/**
	 * An optional host value for a {@link io.fabric8.openshift.api.model.Route}. This value will
	 * override the default of combining the appId, namespace/project and default routing subdomain
	 * (see {@link OpenShiftDeployerProperties#defaultRoutingSubdomain}). See
	 * https://docs.openshift.org/latest/architecture/core_concepts/routes.html#route- hostnames
	 */
	String OPENSHIFT_DEPLOYMENT_ROUTE_HOSTNAME = "spring.cloud.deployer.openshift.deployment.route.host";

	/**
	 * An optional list of {@link io.fabric8.kubernetes.api.model.VolumeMount}s.
	 * <code>spring.cloud.deployer.openshift.deployment.volumeMounts=volumeName:mountPath[:readOnly],...</code>
	 */
	String OPENSHIFT_DEPLOYMENT_VOLUME_MOUNTS = "spring.cloud.deployer.openshift.deployment.volumeMounts";

	/**
	 * An optional comma separated list of labels to add to the DeploymentConfig. This could be
	 * useful for grouping different standalone/stream/tasks into common view/application group etc.
	 * <code>spring.cloud.deployer.openshift.deployment.labels=groupName=test,someLabel=value</code>
	 */
	String OPENSHIFT_DEPLOYMENT_LABELS = "spring.cloud.deployer.openshift.deployment.labels";

	/**
	 * The below two properties are equal (a Kubernetes "LoadBalancer" is equivalent to a Route in
	 * OpenShift - see
	 * {@link org.springframework.cloud.deployer.spi.kubernetes.KubernetesAppDeployer}) in meaning.
	 * Whether or not to create a OpenShift Route. See
	 * https://docs.openshift.org/latest/dev_guide/routes.html
	 */
	String KUBERNETES_CREATE_LOAD_BALANCER = "spring.cloud.deployer.kubernetes.createLoadBalancer";
	String OPENSHIFT_CREATE_ROUTE = "spring.cloud.deployer.openshift.createRoute";

	/**
	 * Create a NodePort instead of a Route. Either "true" or a number at deployment time. The value
	 * "true" will choose a random port. If a number is given it must be in the range that is
	 * configured for the cluster (service-node-port-range, default is 30000-32767).
	 */
	String OPENSHIFT_CREATE_NODE_PORT = "spring.cloud.deployer.openshift.createNodePort";

	/**
	 * A comma separated list of environment variables. Primarily used
	 */
	String OPENSHIFT_DEPLOYMENT_ENVIRONMENT_VARIABLES = "spring.cloud.deployer.openshift.environmentVariables";

	/**
	 * Custom container command.
	 */
	String OPENSHIFT_DEPLOYMENT_CONTAINER_COMMAND = "spring.cloud.deployer.openshift.containerCommand";

	/**
	 * Additional (in addition to default Spring Boot port) container ports to that should exposed.
	 */
	String OPENSHIFT_DEPLOYMENT_CONTAINER_PORTS = "spring.cloud.deployer.openshift.containerPorts";

	/**
	 * The Docker ENTRYPOINT style used when running the container. This determines how command line
	 * arguments are passed to the container. See
	 * {@link org.springframework.cloud.deployer.spi.openshift.resources.pod.OpenShiftContainerFactory}
	 */
	String OPENSHIFT_DEPLOYMENT_CONTAINER_ENTRYPOINT_STYLE = "spring.cloud.deployer.openshift.entryPointStyle";
}
