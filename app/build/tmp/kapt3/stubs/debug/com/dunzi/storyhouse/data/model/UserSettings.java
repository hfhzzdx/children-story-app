package com.dunzi.storyhouse.data.model;

/**
 * 用户设置实体类
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000K\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0003\b\u0086\u0001\b\u0087\b\u0018\u00002\u00020\u0001B\u00c5\u0004\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u001b\u0012\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u001b\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u000e\u0012\b\b\u0002\u0010 \u001a\u00020\u000e\u0012\b\b\u0002\u0010!\u001a\u00020\u000e\u0012\b\b\u0002\u0010\"\u001a\u00020\u000e\u0012\b\b\u0002\u0010#\u001a\u00020\u000e\u0012\b\b\u0002\u0010$\u001a\u00020\u000e\u0012\b\b\u0002\u0010%\u001a\u00020\u000e\u0012\b\b\u0002\u0010&\u001a\u00020\u000e\u0012\b\b\u0002\u0010\'\u001a\u00020\u0003\u0012\b\b\u0002\u0010(\u001a\u00020\u0012\u0012\b\b\u0002\u0010)\u001a\u00020\u000e\u0012\b\b\u0002\u0010*\u001a\u00020\u000e\u0012\b\b\u0002\u0010+\u001a\u00020\u000e\u0012\b\b\u0002\u0010,\u001a\u00020\u000e\u0012\b\b\u0002\u0010-\u001a\u00020\u000e\u0012\b\b\u0002\u0010.\u001a\u00020\u0003\u0012\b\b\u0002\u0010/\u001a\u00020\n\u0012\b\b\u0002\u00100\u001a\u00020\u000e\u0012\b\b\u0002\u00101\u001a\u00020\u0003\u0012\b\b\u0002\u00102\u001a\u00020\u000e\u0012\b\b\u0002\u00103\u001a\u00020\u0012\u0012\b\b\u0002\u00104\u001a\u00020\u000e\u0012\b\b\u0002\u00105\u001a\u00020\u000e\u0012\b\b\u0002\u00106\u001a\u00020\u000e\u0012\b\b\u0002\u00107\u001a\u00020\u000e\u0012\b\b\u0002\u00108\u001a\u000209\u0012\b\b\u0002\u0010:\u001a\u000209\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u000109\u0012\b\b\u0002\u0010<\u001a\u00020\u0012\u0012\b\b\u0002\u0010=\u001a\u00020\u0006\u0012\b\b\u0002\u0010>\u001a\u00020\u0006\u0012\u0014\b\u0002\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030@\u00a2\u0006\u0002\u0010AJ\n\u0010\u0081\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0082\u0001\u001a\u00020\u000eH\u00c6\u0003J\n\u0010\u0083\u0001\u001a\u00020\u000eH\u00c6\u0003J\n\u0010\u0084\u0001\u001a\u00020\u0012H\u00c6\u0003J\n\u0010\u0085\u0001\u001a\u00020\u000eH\u00c6\u0003J\n\u0010\u0086\u0001\u001a\u00020\u0012H\u00c6\u0003J\n\u0010\u0087\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0088\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0089\u0001\u001a\u00020\u000eH\u00c6\u0003J\n\u0010\u008a\u0001\u001a\u00020\u000eH\u00c6\u0003J\n\u0010\u008b\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u008c\u0001\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010\u008d\u0001\u001a\b\u0012\u0004\u0012\u00020\u00030\u001bH\u00c6\u0003J\u0010\u0010\u008e\u0001\u001a\b\u0012\u0004\u0012\u00020\u00030\u001bH\u00c6\u0003J\n\u0010\u008f\u0001\u001a\u00020\u000eH\u00c6\u0003J\n\u0010\u0090\u0001\u001a\u00020\u000eH\u00c6\u0003J\n\u0010\u0091\u0001\u001a\u00020\u000eH\u00c6\u0003J\n\u0010\u0092\u0001\u001a\u00020\u000eH\u00c6\u0003J\n\u0010\u0093\u0001\u001a\u00020\u000eH\u00c6\u0003J\n\u0010\u0094\u0001\u001a\u00020\u000eH\u00c6\u0003J\n\u0010\u0095\u0001\u001a\u00020\u000eH\u00c6\u0003J\n\u0010\u0096\u0001\u001a\u00020\u000eH\u00c6\u0003J\n\u0010\u0097\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u0098\u0001\u001a\u00020\u000eH\u00c6\u0003J\n\u0010\u0099\u0001\u001a\u00020\u000eH\u00c6\u0003J\n\u0010\u009a\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u009b\u0001\u001a\u00020\u0012H\u00c6\u0003J\n\u0010\u009c\u0001\u001a\u00020\u000eH\u00c6\u0003J\n\u0010\u009d\u0001\u001a\u00020\u000eH\u00c6\u0003J\n\u0010\u009e\u0001\u001a\u00020\u000eH\u00c6\u0003J\n\u0010\u009f\u0001\u001a\u00020\u000eH\u00c6\u0003J\n\u0010\u00a0\u0001\u001a\u00020\u000eH\u00c6\u0003J\n\u0010\u00a1\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00a2\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00a3\u0001\u001a\u00020\nH\u00c6\u0003J\n\u0010\u00a4\u0001\u001a\u00020\u000eH\u00c6\u0003J\n\u0010\u00a5\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00a6\u0001\u001a\u00020\u000eH\u00c6\u0003J\n\u0010\u00a7\u0001\u001a\u00020\u0012H\u00c6\u0003J\n\u0010\u00a8\u0001\u001a\u00020\u000eH\u00c6\u0003J\n\u0010\u00a9\u0001\u001a\u00020\u000eH\u00c6\u0003J\n\u0010\u00aa\u0001\u001a\u00020\u000eH\u00c6\u0003J\n\u0010\u00ab\u0001\u001a\u00020\u000eH\u00c6\u0003J\n\u0010\u00ac\u0001\u001a\u000209H\u00c6\u0003J\n\u0010\u00ad\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00ae\u0001\u001a\u000209H\u00c6\u0003J\f\u0010\u00af\u0001\u001a\u0004\u0018\u000109H\u00c6\u0003J\n\u0010\u00b0\u0001\u001a\u00020\u0012H\u00c6\u0003J\n\u0010\u00b1\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u00b2\u0001\u001a\u00020\u0006H\u00c6\u0003J\u0016\u0010\u00b3\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030@H\u00c6\u0003J\n\u0010\u00b4\u0001\u001a\u00020\nH\u00c6\u0003J\n\u0010\u00b5\u0001\u001a\u00020\nH\u00c6\u0003J\n\u0010\u00b6\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00b7\u0001\u001a\u00020\u000eH\u00c6\u0003J\u00ca\u0004\u0010\u00b8\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u000e2\b\b\u0002\u0010\u0018\u001a\u00020\u000e2\b\b\u0002\u0010\u0019\u001a\u00020\u00032\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u001b2\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\u000e2\b\b\u0002\u0010\u001e\u001a\u00020\u000e2\b\b\u0002\u0010\u001f\u001a\u00020\u000e2\b\b\u0002\u0010 \u001a\u00020\u000e2\b\b\u0002\u0010!\u001a\u00020\u000e2\b\b\u0002\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020\u000e2\b\b\u0002\u0010$\u001a\u00020\u000e2\b\b\u0002\u0010%\u001a\u00020\u000e2\b\b\u0002\u0010&\u001a\u00020\u000e2\b\b\u0002\u0010\'\u001a\u00020\u00032\b\b\u0002\u0010(\u001a\u00020\u00122\b\b\u0002\u0010)\u001a\u00020\u000e2\b\b\u0002\u0010*\u001a\u00020\u000e2\b\b\u0002\u0010+\u001a\u00020\u000e2\b\b\u0002\u0010,\u001a\u00020\u000e2\b\b\u0002\u0010-\u001a\u00020\u000e2\b\b\u0002\u0010.\u001a\u00020\u00032\b\b\u0002\u0010/\u001a\u00020\n2\b\b\u0002\u00100\u001a\u00020\u000e2\b\b\u0002\u00101\u001a\u00020\u00032\b\b\u0002\u00102\u001a\u00020\u000e2\b\b\u0002\u00103\u001a\u00020\u00122\b\b\u0002\u00104\u001a\u00020\u000e2\b\b\u0002\u00105\u001a\u00020\u000e2\b\b\u0002\u00106\u001a\u00020\u000e2\b\b\u0002\u00107\u001a\u00020\u000e2\b\b\u0002\u00108\u001a\u0002092\b\b\u0002\u0010:\u001a\u0002092\n\b\u0002\u0010;\u001a\u0004\u0018\u0001092\b\b\u0002\u0010<\u001a\u00020\u00122\b\b\u0002\u0010=\u001a\u00020\u00062\b\b\u0002\u0010>\u001a\u00020\u00062\u0014\b\u0002\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030@H\u00c6\u0001J\u0015\u0010\u00b9\u0001\u001a\u00020\u000e2\t\u0010\u00ba\u0001\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\u0007\u0010\u00bb\u0001\u001a\u00020\u0003J\u0007\u0010\u00bc\u0001\u001a\u00020\u0006J\u0007\u0010\u00bd\u0001\u001a\u00020\u0003J\u0010\u0010\u00be\u0001\u001a\u00020\u00122\u0007\u0010\u00bf\u0001\u001a\u00020\u0012J\u0007\u0010\u00c0\u0001\u001a\u00020\u0003J\u0007\u0010\u00c1\u0001\u001a\u00020\u0006J\u0007\u0010\u00c2\u0001\u001a\u00020\u0003J\n\u0010\u00c3\u0001\u001a\u00020\u0006H\u00d6\u0001J\u0010\u0010\u00c4\u0001\u001a\u00020\u000e2\u0007\u0010\u00bf\u0001\u001a\u00020\u0012J\n\u0010\u00c5\u0001\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u001d\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0011\u0010!\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\bD\u0010CR\u0011\u0010\u0018\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\bE\u0010CR\u0011\u0010)\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\bF\u0010CR\u0011\u0010&\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\bG\u0010CR\u0011\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\bH\u0010CR\u0011\u0010-\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\bI\u0010CR\u0011\u0010.\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u0011\u0010/\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\bN\u0010CR\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\bO\u0010PR\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\bQ\u0010PR\u0011\u0010(\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\bR\u0010SR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\bT\u0010UR\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bV\u0010KR\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bW\u0010KR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bX\u0010KR\u0011\u0010\u0019\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bY\u0010KR\u0011\u00108\u001a\u000209\u00a2\u0006\b\n\u0000\u001a\u0004\bZ\u0010[R\u0011\u00103\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\\\u0010SR\u001d\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030@\u00a2\u0006\b\n\u0000\u001a\u0004\b]\u0010^R\u0011\u0010\u0014\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b_\u0010SR\u0011\u0010\u0013\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b`\u0010CR\u0011\u0010 \u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\ba\u0010CR\u0011\u0010+\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\bb\u0010CR\u0011\u0010\u000b\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\bc\u0010MR\u0011\u0010\f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bd\u0010KR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\be\u0010MR\u0011\u0010\u0017\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\bf\u0010CR\u0011\u0010>\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\bg\u0010UR\u0011\u0010\u0016\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bh\u0010KR\u0013\u0010;\u001a\u0004\u0018\u000109\u00a2\u0006\b\n\u0000\u001a\u0004\bi\u0010[R\u0011\u00104\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\bj\u0010CR\u0011\u0010\"\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\bk\u0010CR\u0011\u0010\u001e\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\bl\u0010CR\u0011\u00101\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bm\u0010KR\u0011\u0010%\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\bn\u0010CR\u0011\u0010\u001f\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\bo\u0010CR\u0011\u0010#\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\bp\u0010CR\u0011\u00105\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\bq\u0010CR\u0011\u00106\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\br\u0010CR\u0011\u00102\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\bs\u0010CR\u0011\u0010\u0011\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\bt\u0010SR\u0011\u0010\u0010\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\bu\u0010CR\u0011\u00100\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\bv\u0010CR\u0011\u0010\'\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bw\u0010KR\u0011\u0010=\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\bx\u0010UR\u0011\u0010,\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\by\u0010CR\u0011\u0010\u0015\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bz\u0010KR\u0011\u0010<\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b{\u0010SR\u0011\u0010$\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b|\u0010CR\u0011\u0010:\u001a\u000209\u00a2\u0006\b\n\u0000\u001a\u0004\b}\u0010[R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b~\u0010KR\u0011\u00107\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u007f\u0010CR\u0012\u0010*\u001a\u00020\u000e\u00a2\u0006\t\n\u0000\u001a\u0005\b\u0080\u0001\u0010C\u00a8\u0006\u00c6\u0001"}, d2 = {"Lcom/dunzi/storyhouse/data/model/UserSettings;", "", "userId", "", "childName", "childAge", "", "childGender", "childAvatar", "defaultVolume", "", "defaultPlaybackSpeed", "defaultVoiceType", "backgroundPlay", "", "autoPlayNext", "sleepTimerEnabled", "sleepTimerDuration", "", "dailyLimitEnabled", "dailyLimitDuration", "theme", "fontSize", "eyeProtectionMode", "animationEnabled", "contentFilterLevel", "blockedCategories", "", "blockedTags", "ageRestriction", "parentalControlEnabled", "purchaseLock", "dataCollectionAllowed", "analyticsEnabled", "notificationsEnabled", "reminderNotifications", "updateNotifications", "promotionalNotifications", "autoDownloadFavorites", "storageLocation", "cacheSizeLimit", "autoClearCache", "wifiOnlyDownload", "dataSaverMode", "syncEnabled", "backgroundMusic", "backgroundMusicType", "backgroundMusicVolume", "soundEffects", "playMode", "shuffleEnabled", "crossfadeDuration", "learningMode", "repeatDifficultParts", "showSubtitles", "vocabularyHighlight", "createdAt", "Ljava/util/Date;", "updatedAt", "lastLoginAt", "totalPlayTime", "storiesCompleted", "favoritesCount", "customSettings", "", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;FFLjava/lang/String;ZZZJZJLjava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/util/List;Ljava/util/List;ZZZZZZZZZZLjava/lang/String;JZZZZZLjava/lang/String;FZLjava/lang/String;ZJZZZZLjava/util/Date;Ljava/util/Date;Ljava/util/Date;JIILjava/util/Map;)V", "getAgeRestriction", "()Z", "getAnalyticsEnabled", "getAnimationEnabled", "getAutoClearCache", "getAutoDownloadFavorites", "getAutoPlayNext", "getBackgroundMusic", "getBackgroundMusicType", "()Ljava/lang/String;", "getBackgroundMusicVolume", "()F", "getBackgroundPlay", "getBlockedCategories", "()Ljava/util/List;", "getBlockedTags", "getCacheSizeLimit", "()J", "getChildAge", "()I", "getChildAvatar", "getChildGender", "getChildName", "getContentFilterLevel", "getCreatedAt", "()Ljava/util/Date;", "getCrossfadeDuration", "getCustomSettings", "()Ljava/util/Map;", "getDailyLimitDuration", "getDailyLimitEnabled", "getDataCollectionAllowed", "getDataSaverMode", "getDefaultPlaybackSpeed", "getDefaultVoiceType", "getDefaultVolume", "getEyeProtectionMode", "getFavoritesCount", "getFontSize", "getLastLoginAt", "getLearningMode", "getNotificationsEnabled", "getParentalControlEnabled", "getPlayMode", "getPromotionalNotifications", "getPurchaseLock", "getReminderNotifications", "getRepeatDifficultParts", "getShowSubtitles", "getShuffleEnabled", "getSleepTimerDuration", "getSleepTimerEnabled", "getSoundEffects", "getStorageLocation", "getStoriesCompleted", "getSyncEnabled", "getTheme", "getTotalPlayTime", "getUpdateNotifications", "getUpdatedAt", "getUserId", "getVocabularyHighlight", "getWifiOnlyDownload", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component5", "component50", "component51", "component52", "component53", "component54", "component55", "component6", "component7", "component8", "component9", "copy", "equals", "other", "getDailyLimitString", "getFontSizeResource", "getPlayModeDisplayName", "getRemainingPlayTime", "todayPlayTime", "getSleepTimerString", "getThemeResource", "getVoiceTypeDisplayName", "hashCode", "isDailyLimitReached", "toString", "app_debug"})
@androidx.room.Entity(tableName = "user_settings")
@androidx.room.TypeConverters(value = {com.dunzi.storyhouse.data.converter.DateConverter.class, com.dunzi.storyhouse.data.converter.MapConverter.class})
public final class UserSettings {
    @androidx.room.PrimaryKey()
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String userId = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String childName = null;
    private final int childAge = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String childGender = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String childAvatar = null;
    private final float defaultVolume = 0.0F;
    private final float defaultPlaybackSpeed = 0.0F;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String defaultVoiceType = null;
    private final boolean backgroundPlay = false;
    private final boolean autoPlayNext = false;
    private final boolean sleepTimerEnabled = false;
    private final long sleepTimerDuration = 0L;
    private final boolean dailyLimitEnabled = false;
    private final long dailyLimitDuration = 0L;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String theme = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String fontSize = null;
    private final boolean eyeProtectionMode = false;
    private final boolean animationEnabled = false;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String contentFilterLevel = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> blockedCategories = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> blockedTags = null;
    private final boolean ageRestriction = false;
    private final boolean parentalControlEnabled = false;
    private final boolean purchaseLock = false;
    private final boolean dataCollectionAllowed = false;
    private final boolean analyticsEnabled = false;
    private final boolean notificationsEnabled = false;
    private final boolean reminderNotifications = false;
    private final boolean updateNotifications = false;
    private final boolean promotionalNotifications = false;
    private final boolean autoDownloadFavorites = false;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String storageLocation = null;
    private final long cacheSizeLimit = 0L;
    private final boolean autoClearCache = false;
    private final boolean wifiOnlyDownload = false;
    private final boolean dataSaverMode = false;
    private final boolean syncEnabled = false;
    private final boolean backgroundMusic = false;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String backgroundMusicType = null;
    private final float backgroundMusicVolume = 0.0F;
    private final boolean soundEffects = false;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String playMode = null;
    private final boolean shuffleEnabled = false;
    private final long crossfadeDuration = 0L;
    private final boolean learningMode = false;
    private final boolean repeatDifficultParts = false;
    private final boolean showSubtitles = false;
    private final boolean vocabularyHighlight = false;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Date createdAt = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Date updatedAt = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.Date lastLoginAt = null;
    private final long totalPlayTime = 0L;
    private final int storiesCompleted = 0;
    private final int favoritesCount = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.String, java.lang.String> customSettings = null;
    
    public UserSettings(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.lang.String childName, int childAge, @org.jetbrains.annotations.NotNull()
    java.lang.String childGender, @org.jetbrains.annotations.NotNull()
    java.lang.String childAvatar, float defaultVolume, float defaultPlaybackSpeed, @org.jetbrains.annotations.NotNull()
    java.lang.String defaultVoiceType, boolean backgroundPlay, boolean autoPlayNext, boolean sleepTimerEnabled, long sleepTimerDuration, boolean dailyLimitEnabled, long dailyLimitDuration, @org.jetbrains.annotations.NotNull()
    java.lang.String theme, @org.jetbrains.annotations.NotNull()
    java.lang.String fontSize, boolean eyeProtectionMode, boolean animationEnabled, @org.jetbrains.annotations.NotNull()
    java.lang.String contentFilterLevel, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> blockedCategories, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> blockedTags, boolean ageRestriction, boolean parentalControlEnabled, boolean purchaseLock, boolean dataCollectionAllowed, boolean analyticsEnabled, boolean notificationsEnabled, boolean reminderNotifications, boolean updateNotifications, boolean promotionalNotifications, boolean autoDownloadFavorites, @org.jetbrains.annotations.NotNull()
    java.lang.String storageLocation, long cacheSizeLimit, boolean autoClearCache, boolean wifiOnlyDownload, boolean dataSaverMode, boolean syncEnabled, boolean backgroundMusic, @org.jetbrains.annotations.NotNull()
    java.lang.String backgroundMusicType, float backgroundMusicVolume, boolean soundEffects, @org.jetbrains.annotations.NotNull()
    java.lang.String playMode, boolean shuffleEnabled, long crossfadeDuration, boolean learningMode, boolean repeatDifficultParts, boolean showSubtitles, boolean vocabularyHighlight, @org.jetbrains.annotations.NotNull()
    java.util.Date createdAt, @org.jetbrains.annotations.NotNull()
    java.util.Date updatedAt, @org.jetbrains.annotations.Nullable()
    java.util.Date lastLoginAt, long totalPlayTime, int storiesCompleted, int favoritesCount, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> customSettings) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUserId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getChildName() {
        return null;
    }
    
    public final int getChildAge() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getChildGender() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getChildAvatar() {
        return null;
    }
    
    public final float getDefaultVolume() {
        return 0.0F;
    }
    
    public final float getDefaultPlaybackSpeed() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDefaultVoiceType() {
        return null;
    }
    
    public final boolean getBackgroundPlay() {
        return false;
    }
    
    public final boolean getAutoPlayNext() {
        return false;
    }
    
    public final boolean getSleepTimerEnabled() {
        return false;
    }
    
    public final long getSleepTimerDuration() {
        return 0L;
    }
    
    public final boolean getDailyLimitEnabled() {
        return false;
    }
    
    public final long getDailyLimitDuration() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTheme() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFontSize() {
        return null;
    }
    
    public final boolean getEyeProtectionMode() {
        return false;
    }
    
    public final boolean getAnimationEnabled() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getContentFilterLevel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getBlockedCategories() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getBlockedTags() {
        return null;
    }
    
    public final boolean getAgeRestriction() {
        return false;
    }
    
    public final boolean getParentalControlEnabled() {
        return false;
    }
    
    public final boolean getPurchaseLock() {
        return false;
    }
    
    public final boolean getDataCollectionAllowed() {
        return false;
    }
    
    public final boolean getAnalyticsEnabled() {
        return false;
    }
    
    public final boolean getNotificationsEnabled() {
        return false;
    }
    
    public final boolean getReminderNotifications() {
        return false;
    }
    
    public final boolean getUpdateNotifications() {
        return false;
    }
    
    public final boolean getPromotionalNotifications() {
        return false;
    }
    
    public final boolean getAutoDownloadFavorites() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStorageLocation() {
        return null;
    }
    
    public final long getCacheSizeLimit() {
        return 0L;
    }
    
    public final boolean getAutoClearCache() {
        return false;
    }
    
    public final boolean getWifiOnlyDownload() {
        return false;
    }
    
    public final boolean getDataSaverMode() {
        return false;
    }
    
    public final boolean getSyncEnabled() {
        return false;
    }
    
    public final boolean getBackgroundMusic() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBackgroundMusicType() {
        return null;
    }
    
    public final float getBackgroundMusicVolume() {
        return 0.0F;
    }
    
    public final boolean getSoundEffects() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPlayMode() {
        return null;
    }
    
    public final boolean getShuffleEnabled() {
        return false;
    }
    
    public final long getCrossfadeDuration() {
        return 0L;
    }
    
    public final boolean getLearningMode() {
        return false;
    }
    
    public final boolean getRepeatDifficultParts() {
        return false;
    }
    
    public final boolean getShowSubtitles() {
        return false;
    }
    
    public final boolean getVocabularyHighlight() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Date getCreatedAt() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Date getUpdatedAt() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.Date getLastLoginAt() {
        return null;
    }
    
    public final long getTotalPlayTime() {
        return 0L;
    }
    
    public final int getStoriesCompleted() {
        return 0;
    }
    
    public final int getFavoritesCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.String> getCustomSettings() {
        return null;
    }
    
    /**
     * 获取主题资源ID
     */
    public final int getThemeResource() {
        return 0;
    }
    
    /**
     * 获取字体大小资源
     */
    public final int getFontSizeResource() {
        return 0;
    }
    
    /**
     * 获取每日限制时间字符串
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDailyLimitString() {
        return null;
    }
    
    /**
     * 获取睡眠定时时间字符串
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSleepTimerString() {
        return null;
    }
    
    /**
     * 检查是否达到每日限制
     */
    public final boolean isDailyLimitReached(long todayPlayTime) {
        return false;
    }
    
    /**
     * 获取剩余播放时间
     */
    public final long getRemainingPlayTime(long todayPlayTime) {
        return 0L;
    }
    
    /**
     * 获取语音类型显示名称
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getVoiceTypeDisplayName() {
        return null;
    }
    
    /**
     * 获取播放模式显示名称
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPlayModeDisplayName() {
        return null;
    }
    
    public UserSettings() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    public final boolean component10() {
        return false;
    }
    
    public final boolean component11() {
        return false;
    }
    
    public final long component12() {
        return 0L;
    }
    
    public final boolean component13() {
        return false;
    }
    
    public final long component14() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component15() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component16() {
        return null;
    }
    
    public final boolean component17() {
        return false;
    }
    
    public final boolean component18() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component19() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component20() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component21() {
        return null;
    }
    
    public final boolean component22() {
        return false;
    }
    
    public final boolean component23() {
        return false;
    }
    
    public final boolean component24() {
        return false;
    }
    
    public final boolean component25() {
        return false;
    }
    
    public final boolean component26() {
        return false;
    }
    
    public final boolean component27() {
        return false;
    }
    
    public final boolean component28() {
        return false;
    }
    
    public final boolean component29() {
        return false;
    }
    
    public final int component3() {
        return 0;
    }
    
    public final boolean component30() {
        return false;
    }
    
    public final boolean component31() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component32() {
        return null;
    }
    
    public final long component33() {
        return 0L;
    }
    
    public final boolean component34() {
        return false;
    }
    
    public final boolean component35() {
        return false;
    }
    
    public final boolean component36() {
        return false;
    }
    
    public final boolean component37() {
        return false;
    }
    
    public final boolean component38() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component39() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    public final float component40() {
        return 0.0F;
    }
    
    public final boolean component41() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component42() {
        return null;
    }
    
    public final boolean component43() {
        return false;
    }
    
    public final long component44() {
        return 0L;
    }
    
    public final boolean component45() {
        return false;
    }
    
    public final boolean component46() {
        return false;
    }
    
    public final boolean component47() {
        return false;
    }
    
    public final boolean component48() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Date component49() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Date component50() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.Date component51() {
        return null;
    }
    
    public final long component52() {
        return 0L;
    }
    
    public final int component53() {
        return 0;
    }
    
    public final int component54() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.String> component55() {
        return null;
    }
    
    public final float component6() {
        return 0.0F;
    }
    
    public final float component7() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component8() {
        return null;
    }
    
    public final boolean component9() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.dunzi.storyhouse.data.model.UserSettings copy(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.lang.String childName, int childAge, @org.jetbrains.annotations.NotNull()
    java.lang.String childGender, @org.jetbrains.annotations.NotNull()
    java.lang.String childAvatar, float defaultVolume, float defaultPlaybackSpeed, @org.jetbrains.annotations.NotNull()
    java.lang.String defaultVoiceType, boolean backgroundPlay, boolean autoPlayNext, boolean sleepTimerEnabled, long sleepTimerDuration, boolean dailyLimitEnabled, long dailyLimitDuration, @org.jetbrains.annotations.NotNull()
    java.lang.String theme, @org.jetbrains.annotations.NotNull()
    java.lang.String fontSize, boolean eyeProtectionMode, boolean animationEnabled, @org.jetbrains.annotations.NotNull()
    java.lang.String contentFilterLevel, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> blockedCategories, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> blockedTags, boolean ageRestriction, boolean parentalControlEnabled, boolean purchaseLock, boolean dataCollectionAllowed, boolean analyticsEnabled, boolean notificationsEnabled, boolean reminderNotifications, boolean updateNotifications, boolean promotionalNotifications, boolean autoDownloadFavorites, @org.jetbrains.annotations.NotNull()
    java.lang.String storageLocation, long cacheSizeLimit, boolean autoClearCache, boolean wifiOnlyDownload, boolean dataSaverMode, boolean syncEnabled, boolean backgroundMusic, @org.jetbrains.annotations.NotNull()
    java.lang.String backgroundMusicType, float backgroundMusicVolume, boolean soundEffects, @org.jetbrains.annotations.NotNull()
    java.lang.String playMode, boolean shuffleEnabled, long crossfadeDuration, boolean learningMode, boolean repeatDifficultParts, boolean showSubtitles, boolean vocabularyHighlight, @org.jetbrains.annotations.NotNull()
    java.util.Date createdAt, @org.jetbrains.annotations.NotNull()
    java.util.Date updatedAt, @org.jetbrains.annotations.Nullable()
    java.util.Date lastLoginAt, long totalPlayTime, int storiesCompleted, int favoritesCount, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> customSettings) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}