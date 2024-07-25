load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

android_sdk_repository(
    name = "androidsdk",
    api_level = 31,
    build_tools_version = "30.0.2",
)

RULES_JVM_EXTERNAL_TAG = "4.5"

RULES_JVM_EXTERNAL_SHA = "b17d7388feb9bfa7f2fa09031b32707df529f26c91ab9e5d909eb1676badd9a6"

http_archive(
    name = "rules_jvm_external",
    sha256 = RULES_JVM_EXTERNAL_SHA,
    strip_prefix = "rules_jvm_external-%s" % RULES_JVM_EXTERNAL_TAG,
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/%s.zip" % RULES_JVM_EXTERNAL_TAG,
)

load("@rules_jvm_external//:repositories.bzl", "rules_jvm_external_deps")

rules_jvm_external_deps()

load("@rules_jvm_external//:setup.bzl", "rules_jvm_external_setup")

rules_jvm_external_setup()

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

