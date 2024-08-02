load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

android_sdk_repository(
    name = "androidsdk",
    api_level = 31,
    build_tools_version = "30.0.2",
)

RULES_JVM_EXTERNAL_TAG = "6.2"
RULES_JVM_EXTERNAL_SHA = "808cb5c30b5f70d12a2a745a29edc46728fd35fa195c1762a596b63ae9cebe05"

http_archive(
    name = "rules_jvm_external",
    strip_prefix = "rules_jvm_external-%s" % RULES_JVM_EXTERNAL_TAG,
    sha256 = RULES_JVM_EXTERNAL_SHA,
    url = "https://github.com/bazelbuild/rules_jvm_external/releases/download/%s/rules_jvm_external-%s.tar.gz" % (RULES_JVM_EXTERNAL_TAG, RULES_JVM_EXTERNAL_TAG)
)

load("@rules_jvm_external//:repositories.bzl", "rules_jvm_external_deps")

rules_jvm_external_deps()

load("@rules_jvm_external//:setup.bzl", "rules_jvm_external_setup")

rules_jvm_external_setup()

SKYLIB_VERSION = "1.0.2"
SKYLIB_SHA = "97e70364e9249702246c0e9444bccdc4b847bed1eb03c5a3ece4f83dfe6abc44"

http_archive(
    name = "bazel_skylib",
    sha256 = SKYLIB_SHA,
    urls = [
        "https://mirror.bazel.build/github.com/bazelbuild/bazel-skylib/releases/download/%s/bazel-skylib-%s.tar.gz" % (SKYLIB_VERSION, SKYLIB_VERSION),
        "https://github.com/bazelbuild/bazel-skylib/releases/download/%s/bazel-skylib-%s.tar.gz" % (SKYLIB_VERSION, SKYLIB_VERSION),
    ],
)

load("@rules_jvm_external//:defs.bzl", "maven_install")

# bazelisk run @unpinned_maven//:pin
maven_install(
    artifacts = [
        "com.google.android.exoplayer:exoplayer-core:2.17.1",
        "junit:junit:4.12",
        "androidx.test:monitor:1.2.0",
        "androidx.test.espresso:espresso-core:3.5.1",
        "androidx.test:runner:1.2.0",
        "androidx.test:core:1.2.0",
        "androidx.test:rules:1.2.0",
        "androidx.test.ext:junit:1.1.1",
        "androidx.constraintlayout:constraintlayout:2.1.3",
    ],
    repositories = [
        "https://maven.google.com",
        "https://repo1.maven.org/maven2",
    ],
    version_conflict_policy = "pinned",
    maven_install_json = "//:maven_install.json",
)

load("@maven//:defs.bzl", "pinned_maven_install")
pinned_maven_install()

http_archive(
    name = "rules_kotlin",
    sha256 = "5766f1e599acf551aa56f49dab9ab9108269b03c557496c54acaf41f98e2b8d6",
    url = "https://github.com/bazelbuild/rules_kotlin/releases/download/v1.9.0/rules_kotlin-v1.9.0.tar.gz",
)

load("@rules_kotlin//kotlin:repositories.bzl", "kotlin_repositories")
kotlin_repositories()

load("@rules_kotlin//kotlin:core.bzl", "kt_register_toolchains")
kt_register_toolchains()

http_archive(
    name = "rules_java",
    urls = [
        "https://github.com/bazelbuild/rules_java/releases/download/7.8.0/rules_java-7.8.0.tar.gz",
    ],
    sha256 = "647bb31c0d51882549def6f67ee9078df697043406ed4a5144bbdf3b17f91e33",
)
load("@rules_java//java:repositories.bzl", "rules_java_dependencies", "rules_java_toolchains")
rules_java_dependencies()
rules_java_toolchains()

register_toolchains("//:java_toolchain_definition")
