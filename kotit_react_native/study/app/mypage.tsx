import { useState } from 'react';
import {
    Button,
    Modal,
    Text,
    TouchableOpacity,
    View,
} from 'react-native';
import { withDecay } from 'react-native-reanimated';
import styles from "./style"

export default function Index() {
    const [open, setOpen] = useState(false);
    function handleOpenModalOnPress() {
        setOpen(!open);
    }

    return (
        <View>
            <Text>마이페이지</Text>
            <Button title={'모달 열기'} onPress={handleOpenModalOnPress} />

            <Modal
                visible={open}
                onRequestClose={() => setOpen(!open)}
                animationType={'slide'}
                presentationStyle={'formSheet'}
            >
                <View style={styles.modalContainer}>
                    <TouchableOpacity
                        style={styles.customBtn}
                        onPress={() => setOpen(!open)}
                    >
                        <Text>디자인 바꿀 수 있는 버튼</Text>
                    </TouchableOpacity>
                    <Button title={'닫기'} onPress={() => setOpen(!open)} />
                </View>
            </Modal>
        </View>
    );
}
