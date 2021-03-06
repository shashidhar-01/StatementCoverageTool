package StatementCoverageTool;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;


/* Similar to one provided for hw2 */
class ClassTransformVisitor extends ClassVisitor implements Opcodes {

    private String className;

    public ClassTransformVisitor(final ClassVisitor cv, final String className) {
        super(ASM5, cv);
        this.className = className;
    }

    @Override
    public MethodVisitor visitMethod(final int access, final String name, final String desc, final String signature, final String[] exceptions) {
        MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);
        return mv == null ? null : new MethodTransformVisitor(mv, name, className);
    }
}