import { useRouter } from 'expo-router';
import { Button, Text, View } from 'react-native';

export default function Index() {
    const router = useRouter();

    function handleMyPageOnPress() {
        router.push('/mypage');
    }

    return (
        <View>
            <Text>인덱스</Text>
            <Button title={'마이페이지 이동'} onPress={handleMyPageOnPress} />
        </View>
    );
}
