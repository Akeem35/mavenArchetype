import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

// the path where the project got generated
Path projectPath = Paths.get(request.outputDirectory, request.artifactId)

Properties properties = request.properties

String connectionType = properties.get("dbHost")

// the Java package of the generated project, e.g. com.acme
String packageName = properties.get("package")

// convert it into a path, e.g. com/acme
String packagePath = packageName.replace(".", "/")

if (connectionType == "true") {
  // delete the FTP file
  Files.deleteIfExists projectPath.resolve("src/main/java/" + packagePath + "/DeleteIfTrue.java")
} 